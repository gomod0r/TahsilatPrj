package tr.gov.gomodor.tahsilatprj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "THS_BORC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borc.kurumBorclariniGetir", query = "SELECT b FROM Borc b WHERE b.kurum.no = :kurumNo AND b.aboneNo = :aboneNo and b.faturaDurum=0 ORDER BY b.faturaSonOdemeTrh"),
    @NamedQuery(name = "Borc.findAll", query = "SELECT b FROM Borc b"),
    @NamedQuery(name = "Borc.findByNo", query = "SELECT b FROM Borc b WHERE b.no = :no"),
    @NamedQuery(name = "Borc.findByAboneNo", query = "SELECT b FROM Borc b WHERE b.aboneNo = :aboneNo"),
    @NamedQuery(name = "Borc.findByAboneAd", query = "SELECT b FROM Borc b WHERE b.aboneAd = :aboneAd"),
    @NamedQuery(name = "Borc.findByAboneSoyad", query = "SELECT b FROM Borc b WHERE b.aboneSoyad = :aboneSoyad"),
    @NamedQuery(name = "Borc.findByFaturaNo", query = "SELECT b FROM Borc b WHERE b.faturaNo = :faturaNo"),
    @NamedQuery(name = "Borc.findByFaturaSonOdemeTrh", query = "SELECT b FROM Borc b WHERE b.faturaSonOdemeTrh = :faturaSonOdemeTrh"),
    @NamedQuery(name = "Borc.findByFaturaTutar", query = "SELECT b FROM Borc b WHERE b.faturaTutar = :faturaTutar"),
    @NamedQuery(name = "Borc.findByFaturaDurum", query = "SELECT b FROM Borc b WHERE b.faturaDurum = :faturaDurum")})
public class Borc implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
    private Integer no;
    @Size(max = 100)
    @Column(name = "ABONE_NO")
    private String aboneNo;
    @Size(max = 30)
    @Column(name = "ABONE_AD")
    private String aboneAd;
    @Size(max = 30)
    @Column(name = "ABONE_SOYAD")
    private String aboneSoyad;
    @Size(max = 100)
    @Column(name = "FATURA_NO")
    private String faturaNo;
    @Column(name = "FATURA_SON_ODEME_TRH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date faturaSonOdemeTrh;
    @Column(name = "FATURA_TUTAR")
    private Double faturaTutar;
    @Column(name = "FATURA_DURUM")
    private Integer faturaDurum;
    @JoinColumn(name = "KURUM_NO", referencedColumnName = "NO")
    @ManyToOne
    private Kurum kurum;

    public Borc() {
    }

    public Borc(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAboneNo() {
        return aboneNo;
    }

    public void setAboneNo(String aboneNo) {
        this.aboneNo = aboneNo;
    }

    public String getAboneAd() {
        return aboneAd;
    }

    public void setAboneAd(String aboneAd) {
        this.aboneAd = aboneAd;
    }

    public String getAboneSoyad() {
        return aboneSoyad;
    }

    public void setAboneSoyad(String aboneSoyad) {
        this.aboneSoyad = aboneSoyad;
    }

    public String getFaturaNo() {
        return faturaNo;
    }

    public void setFaturaNo(String faturaNo) {
        this.faturaNo = faturaNo;
    }

    public Date getFaturaSonOdemeTrh() {
        return faturaSonOdemeTrh;
    }

    public void setFaturaSonOdemeTrh(Date faturaSonOdemeTrh) {
        this.faturaSonOdemeTrh = faturaSonOdemeTrh;
    }

    public Double getFaturaTutar() {
        return faturaTutar;
    }

    public void setFaturaTutar(Double faturaTutar) {
        this.faturaTutar = faturaTutar;
    }

    public Integer getFaturaDurum() {
        return faturaDurum;
    }

    public void setFaturaDurum(Integer faturaDurum) {
        this.faturaDurum = faturaDurum;
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
        if (!(object instanceof Borc)) {
            return false;
        }
        Borc other = (Borc) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.gomodor.tahsilatprj.entity.Borc[ no=" + no + " ]";
    }
    
}
