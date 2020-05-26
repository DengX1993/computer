import javax.persistence.*

@Entity
@Table(name = "SERVER_AND_APP", schema = "springBootTest", catalog = "")
open class SERVERANDAPPEntity {
    @get:Id
    @get:Column(name = "UUID", nullable = false)
    var UUID: String? = null

    @get:Basic
    @get:Column(name = "SERVER_ID", nullable = true)
    var SERVERID: String? = null

    @get:Basic
    @get:Column(name = "APP_ID", nullable = true)
    var APPID: String? = null

    @get:Basic
    @get:Column(name = "EMPLOY_PORT", nullable = true)
    var EMPLOYPORT: Int? = null


    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "UUID = $UUID " +
                    "SERVERID = $SERVERID " +
                    "APPID = $APPID " +
                    "EMPLOYPORT = $EMPLOYPORT " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as SERVERANDAPPEntity

        if (UUID != other.UUID) return false
        if (SERVERID != other.SERVERID) return false
        if (APPID != other.APPID) return false
        if (EMPLOYPORT != other.EMPLOYPORT) return false

        return true
    }

}

