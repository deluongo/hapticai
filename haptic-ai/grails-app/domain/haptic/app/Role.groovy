package haptic.app

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import haptic.eval.Note

/*                          ==============  ***  ==============                          *
 #  ---------------------         Class ~Role~ Definition          --------------------  #
 *                          ===================================                          */


@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

/*  _________________________                                  ________________________  */
/*  ========================= !!! ---*** PROPERTIES ***--- !!! ========================  */


/*  -------------------         *** Instantiate Variables ***       -------------------  */

	// Role Definitions
	public static final String ROLE_ADMIN = 'ROLE_ADMIN'
	public static final String ROLE_USER = 'ROLE_USER'
	public static final String ROLE_ANONYMOUS = 'ROLE_ANONYMOUS'

/*  -------------------             *** Default Params ***          -------------------  */
	private static final long serialVersionUID = 1

	String authority

	static constraints = {
		authority blank: false, unique: true
	}

	static mapping = {
		cache true
	}

/*  -------------------             *** GORM Mapping ***            -------------------  */
	static hasMany = [notes: Note]
}
