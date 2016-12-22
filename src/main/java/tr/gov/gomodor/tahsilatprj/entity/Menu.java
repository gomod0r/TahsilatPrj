package tr.gov.gomodor.tahsilatprj.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "THS_MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByNo", query = "SELECT m FROM Menu m WHERE m.no = :no"),
    @NamedQuery(name = "Menu.findByBaslik", query = "SELECT m FROM Menu m WHERE m.baslik = :baslik"),
    @NamedQuery(name = "Menu.findByLink", query = "SELECT m FROM Menu m WHERE m.link = :link"),
    @NamedQuery(name = "Menu.findBySirano", query = "SELECT m FROM Menu m WHERE m.sirano = :sirano"),
    @NamedQuery(name = "Menu.findByUstmenu", query = "SELECT m FROM Menu m WHERE m.ustmenu = :ustmenu")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
    private Integer no;
    @Size(max = 100)
    @Column(name = "BASLIK")
    private String baslik;
    @Size(max = 250)
    @Column(name = "LINK")
    private String link;
    @Column(name = "SIRANO")
    private Integer sirano;
    @Column(name = "USTMENU")
    private Integer ustmenu;
    @JoinTable(name = "THS_MENU_TIP", joinColumns = {
        @JoinColumn(name = "MENUNO", referencedColumnName = "NO")}, inverseJoinColumns = {
        @JoinColumn(name = "TIPNO", referencedColumnName = "NO")})
    @ManyToMany
    private List<Tip> tipList;

    public Menu() {
    }

    public Menu(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getSirano() {
        return sirano;
    }

    public void setSirano(Integer sirano) {
        this.sirano = sirano;
    }

    public Integer getUstmenu() {
        return ustmenu;
    }

    public void setUstmenu(Integer ustmenu) {
        this.ustmenu = ustmenu;
    }

    @XmlTransient
    public List<Tip> getTipList() {
        return tipList;
    }

    public void setTipList(List<Tip> tipList) {
        this.tipList = tipList;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.gomodor.tahsilatprj.entity.Menu[ no=" + no + " ]";
    }
    
}
