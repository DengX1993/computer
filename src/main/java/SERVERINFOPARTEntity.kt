import javax.persistence.*

@Entity
@Table(name = "SERVER_INFO_PART", schema = "springBootTest", catalog = "")
open class SERVERINFOPARTEntity {
    @get:Id
    @get:Column(name = "UUID", nullable = false)
    var UUID: String? = null

    @get:Basic
    @get:Column(name = "SERVER_ID", nullable = false)
    var SERVERID: String? = null

    @get:Basic
    @get:Column(name = "BELONG_SYS_ID", nullable = true)
    var BELONGSYSID: String? = null

    @get:Basic
    @get:Column(name = "BELONG_SYS_NAME", nullable = true)
    var BELONGSYSNAME: String? = null

    @get:Basic
    @get:Column(name = "ORIGINAL_MEMORY", nullable = true)
    var ORIGINALMEMORY: Int? = null

    @get:Basic
    @get:Column(name = "ORIGINAL_CPU", nullable = true)
    var ORIGINALCPU: Int? = null

    @get:Basic
    @get:Column(name = "ORIGINAL_DISK", nullable = true)
    var ORIGINALDISK: Int? = null

    @get:Basic
    @get:Column(name = "SWAP", nullable = true)
    var SWAP: String? = null

    @get:Basic
    @get:Column(name = "SERVER_TYPE", nullable = true)
    var SERVERTYPE: Int? = null

    @get:Basic
    @get:Column(name = "SERVER_NUM", nullable = true)
    var SERVERNUM: String? = null

    @get:Basic
    @get:Column(name = "NIC_TYPE", nullable = true)
    var NICTYPE: String? = null

    @get:Basic
    @get:Column(name = "NIC_BPS", nullable = true)
    var NICBPS: String? = null

    @get:Basic
    @get:Column(name = "NIC_MAC_ADRESS", nullable = true)
    var NICMACADRESS: String? = null

    @get:Basic
    @get:Column(name = "OTHER_DISK_TYPR", nullable = true)
    var OTHERDISKTYPR: Int? = null

    @get:Basic
    @get:Column(name = "OTHER_DISK_IP", nullable = true)
    var OTHERDISKIP: String? = null

    @get:Basic
    @get:Column(name = "OTHER_DISK_ADRESS", nullable = true)
    var OTHERDISKADRESS: String? = null

    @get:Basic
    @get:Column(name = "OTHER_DISK_SIZE", nullable = true)
    var OTHERDISKSIZE: Int? = null


    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "UUID = $UUID " +
                    "SERVERID = $SERVERID " +
                    "BELONGSYSID = $BELONGSYSID " +
                    "BELONGSYSNAME = $BELONGSYSNAME " +
                    "ORIGINALMEMORY = $ORIGINALMEMORY " +
                    "ORIGINALCPU = $ORIGINALCPU " +
                    "ORIGINALDISK = $ORIGINALDISK " +
                    "SWAP = $SWAP " +
                    "SERVERTYPE = $SERVERTYPE " +
                    "SERVERNUM = $SERVERNUM " +
                    "NICTYPE = $NICTYPE " +
                    "NICBPS = $NICBPS " +
                    "NICMACADRESS = $NICMACADRESS " +
                    "OTHERDISKTYPR = $OTHERDISKTYPR " +
                    "OTHERDISKIP = $OTHERDISKIP " +
                    "OTHERDISKADRESS = $OTHERDISKADRESS " +
                    "OTHERDISKSIZE = $OTHERDISKSIZE " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as SERVERINFOPARTEntity

        if (UUID != other.UUID) return false
        if (SERVERID != other.SERVERID) return false
        if (BELONGSYSID != other.BELONGSYSID) return false
        if (BELONGSYSNAME != other.BELONGSYSNAME) return false
        if (ORIGINALMEMORY != other.ORIGINALMEMORY) return false
        if (ORIGINALCPU != other.ORIGINALCPU) return false
        if (ORIGINALDISK != other.ORIGINALDISK) return false
        if (SWAP != other.SWAP) return false
        if (SERVERTYPE != other.SERVERTYPE) return false
        if (SERVERNUM != other.SERVERNUM) return false
        if (NICTYPE != other.NICTYPE) return false
        if (NICBPS != other.NICBPS) return false
        if (NICMACADRESS != other.NICMACADRESS) return false
        if (OTHERDISKTYPR != other.OTHERDISKTYPR) return false
        if (OTHERDISKIP != other.OTHERDISKIP) return false
        if (OTHERDISKADRESS != other.OTHERDISKADRESS) return false
        if (OTHERDISKSIZE != other.OTHERDISKSIZE) return false

        return true
    }

}

