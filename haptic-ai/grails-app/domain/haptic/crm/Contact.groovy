package haptic.crm

import haptic.eval.Note
import haptic.fields.Address
import haptic.fields.EmailAddress
import haptic.fields.PhoneNumber
import haptic.fields.ReviewSite
import haptic.fields.SocialNetwork
import haptic.fields.WebSite


/*                          ==============  ***  ==============                          *
 #  ---------------------        Class ~Contact~ Definition        --------------------  #
 *                          ===================================                          */


class Contact {


/*  _________________________                                  ________________________  */
/*  ========================= !!! ---*** PROPERTIES ***--- !!! ========================  */


/*  -------------------         *** Instantiate Variables ***       -------------------  */

    // Fixed Fields
    String salutation //Mr., Mrs., etc.
    String firstName
    String lastName
    String gender

    String jobRole
    String jobTitle
    String roleDescription
    String department //For Enterprise companies, which department/group/etc.

    // Possible Mapping, Pivot Table Candidates
    Company company

    /*  -------------------             *** GORM Mapping ***            -------------------  */
    static hasMany = [emailAddresses: EmailAddress, phoneNumbers: PhoneNumber,
    socialNetworks: SocialNetwork, reviewSites: ReviewSite, webSites: WebSite,
    addresses: Address, notes: Note]


    static constraints = {
        salutation inList: ['Mr.', 'Mrs.', 'Ms.', 'Dr.', 'Sir', 'Professor']
        firstName blank: false
        lastName blank: false
        gender  blank: false
        jobTitle blank: false
        jobRole blank: false
        roleDescription nullable: true
        department blank: false

        emailAddresses nullable: true
        phoneNumbers nullable: true
        socialNetworks nullable: true
        reviewSites nullable: true
        webSites nullable: true
        addresses nullable: true
        notes nullable: true
    }

}
