package tr.gov.gomodor.tahsilatprj.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "THS_TAHSILAT_DETAY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TahsilatDetay.findAll", query = "SELECT t FROM TahsilatDetay t"),
    @NamedQuery(name = "TahsilatDetay.findByNo", query = "SELECT t FROM TahsilatDetay t WHERE t.no = :no"),
    @NamedQuery(name = "TahsilatDetay.findByTutar", query = "SELECT t FROM TahsilatDetay t WHERE t.tutar = :tutar"),
    @NamedQuery(name = "TahsilatDetay.findByAboneNo", query = "SELECT t FROM TahsilatDetay t WHERE t.aboneNo = :aboneNo"),
    @NamedQuery(name = "TahsilatDetay.findByFaturaNo", query = "SELECT t FROM TahsilatDetay t WHERE t.faturaNo = :faturaNo"),
    @NamedQuery(name = "TahsilatDetay.findByFaturaSonOdemeTrh", query = "SELECT t FROM TahsilatDetay t WHERE t.faturaSonOdemeTrh = :faturaSonOdemeTrh")})
public class TahsilatDetay implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
    @SequenceGenerator(name = "tahsilatdetayseq", sequenceName = "SEQ_THS_TAHSILAT_DETAY", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "tahsilatdetayseq", strategy = GenerationType.SEQUENCE)
    private Integer no;
    @Column(name = "TUTAR")
    private Double tutar;
    @Size(max = 100)
    @Column(name = "ABONE_NO")
    private String aboneNo;
    @Size(max = 100)
    @Column(name = "FATURA_NO")
    private String faturaNo;
    @Column(name = "FATURA_SON_ODEME_TRH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date faturaSonOdemeTrh;
    @JoinColumn(name = "TAHSILAT_NO", referencedColumnName = "NO")
    @ManyToOne
    private Tahsilat tahsilat;

    public TahsilatDetay() {
    }

    public TahsilatDetay(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    public String getAboneNo() {
        return aboneNo;
    }

    public void setAboneNo(String aboneNo) {
        this.aboneNo = aboneNo;
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

    public Tahsilat getTahsilat() {
        return tahsilat;
    }

    public void setTahsilat(Tahsilat tahsilat) {
        this.tahsilat = tahsilat;
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
        if (!(object instanceof TahsilatDetay)) {
            return false;
        }
        TahsilatDetay other = (TahsilatDetay) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.gomodor.tahsilatprj.entity.TahsilatDetay[ no=" + no + " ]";
    }
    
}
