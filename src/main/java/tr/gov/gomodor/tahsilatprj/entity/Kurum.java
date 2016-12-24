package tr.gov.gomodor.tahsilatprj.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "THS_KURUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kurum.findAll", query = "SELECT k FROM Kurum k"),
    @NamedQuery(name = "Kurum.findByNo", query = "SELECT k FROM Kurum k WHERE k.no = :no"),
    @NamedQuery(name = "Kurum.findByAd", query = "SELECT k FROM Kurum k WHERE k.ad = :ad")})
public class Kurum implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
    private Integer no;
    @Size(max = 250)
    @Column(name = "AD")
    private String ad;
    @OneToMany(mappedBy = "kurum")
    private List<Borc> borcList;
    @OneToMany(mappedBy = "kurum")
    private List<Tahsilat> tahsilatList;

    public Kurum() {
    }

    public Kurum(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @XmlTransient
    public List<Borc> getBorcList() {
        return borcList;
    }

    public void setBorcList(List<Borc> borcList) {
        this.borcList = borcList;
    }

    @XmlTransient
    public List<Tahsilat> getTahsilatList() {
        return tahsilatList;
    }

    public void setTahsilatList(List<Tahsilat> tahsilatList) {
        this.tahsilatList = tahsilatList;
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
        if (!(object instanceof Kurum)) {
            return false;
        }
        Kurum other = (Kurum) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.gomodor.tahsilatprj.entity.Kurum[ no=" + no + " ]";
    }
    
}
