package tr.gov.gomodor.tahsilatprj.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "THS_TAHSILAT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tahsilat.findAll", query = "SELECT t FROM Tahsilat t"),
    @NamedQuery(name = "Tahsilat.findByNo", query = "SELECT t FROM Tahsilat t WHERE t.no = :no"),
    @NamedQuery(name = "Tahsilat.findByIslemTrh", query = "SELECT t FROM Tahsilat t WHERE t.islemTrh = :islemTrh"),
    @NamedQuery(name = "Tahsilat.findByKisiIslemsayi", query = "SELECT t FROM Tahsilat t WHERE t.kisiIslemsayi = :kisiIslemsayi"),
    @NamedQuery(name = "Tahsilat.findByTutar", query = "SELECT t FROM Tahsilat t WHERE t.tutar = :tutar")})
public class Tahsilat implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
    @SequenceGenerator(name = "tahsilatseq", sequenceName = "SEQ_THS_TAHSILAT", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "tahsilatseq", strategy = GenerationType.SEQUENCE)
    private Integer no;
    @Column(name = "ISLEM_TRH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date islemTrh;
    @Column(name = "KISI_ISLEMSAYI")
    private Integer kisiIslemsayi;
    @Column(name = "TUTAR")
    private Double tutar;
    @OneToMany(mappedBy = "tahsilat",cascade = CascadeType.ALL)
    private List<TahsilatDetay> tahsilatDetayList;
    @JoinColumn(name = "KURUM_NO", referencedColumnName = "NO")
    @ManyToOne
    private Kurum kurum;

    @JoinColumn(name = "KISI_NO", referencedColumnName = "NO")
    @ManyToOne
    private Kisi kisi;
    
    public Tahsilat() {
        
        kurum = new Kurum();
        
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public Tahsilat(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Date getIslemTrh() {
        return islemTrh;
    }

    public void setIslemTrh(Date islemTrh) {
        this.islemTrh = islemTrh;
    }

    public Integer getKisiIslemsayi() {
        return kisiIslemsayi;
    }

    public void setKisiIslemsayi(Integer kisiIslemsayi) {
        this.kisiIslemsayi = kisiIslemsayi;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    @XmlTransient
    public List<TahsilatDetay> getTahsilatDetayList() {
        return tahsilatDetayList;
    }

    public void setTahsilatDetayList(List<TahsilatDetay> tahsilatDetayList) {
        this.tahsilatDetayList = tahsilatDetayList;
    }

    public Kurum getKurum() {
        return kurum;
    }

    public void setKurum(Kurum kurum) {
        this.kurum = kurum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tahsilat)) {
            return false;
        }
        Tahsilat other = (Tahsilat) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.gomodor.tahsilatprj.entity.Tahsilat[ no=" + no + " ]";
    }

}
