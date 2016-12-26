package tr.gov.gomodor.tahsilatprj.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import tr.gov.gomodor.tahsilatprj.entity.Borc;
import tr.gov.gomodor.tahsilatprj.entity.Kisi;
import tr.gov.gomodor.tahsilatprj.entity.Tahsilat;
import tr.gov.gomodor.tahsilatprj.entity.TahsilatDetay;
import tr.gov.gomodor.tahsilatprj.facade.BorcFacade;
import tr.gov.gomodor.tahsilatprj.facade.KisiFacade;
import tr.gov.gomodor.tahsilatprj.facade.TahsilatFacade;
import tr.gov.gomodor.util.Ortak;

@Stateless
public class TahsilatService {
    
    @Inject
    private TahsilatFacade tahsilatFacade;
    
    @Inject
    private KisiFacade kisiFacade;
    
    @Inject
    private BorcFacade borcFacade;
    
    //kişi parametresiyle aldıgımız uygulamaya giriş yaptıgımız operatör
    public void ode(List<Borc> p_borclar, Kisi p_kisi){
        
        for (Borc borc : p_borclar) {
            
            Tahsilat tahsilat = new Tahsilat();
            TahsilatDetay tahsilatDetay = new TahsilatDetay();
            
            tahsilat.setIslemTrh(Ortak.sistemTarihiGetirUtilDate());
            tahsilat.setKisi(p_kisi);
            tahsilat.setKisiIslemsayi(p_kisi.getIslemSayi() + 1);
            tahsilat.setKurum(borc.getKurum());
            tahsilat.setTutar(borc.getFaturaTutar());
            
            tahsilatDetay.setTahsilat(tahsilat);
            tahsilatDetay.setTutar(borc.getFaturaTutar());
            tahsilatDetay.setAboneNo(borc.getAboneNo());
            tahsilatDetay.setFaturaNo(borc.getFaturaNo());
            tahsilatDetay.setFaturaSonOdemeTrh(borc.getFaturaSonOdemeTrh());
            
            List<TahsilatDetay> tahsilatDetayList = new ArrayList<TahsilatDetay>();
            tahsilatDetayList.add(tahsilatDetay);
            
            tahsilat.setTahsilatDetayList(tahsilatDetayList);
            
            tahsilatFacade.create(tahsilat);
            
            System.out.println("Tahsilat No:" + tahsilat.getNo());
            
            p_kisi.setIslemSayi(p_kisi.getIslemSayi() + 1);
            kisiFacade.edit(p_kisi);
            
            borc.setFaturaDurum(1);
            borcFacade.edit(borc);
           
        }
        
    }
    
}
