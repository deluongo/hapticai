package haptic.fields

import haptic.connect.Communication
import haptic.eval.Note


/*                          ==============  ***  ==============                          *
 #  ---------------------      Class ~PhoneNumber~ Definition      --------------------  #
 *                          ===================================                          */



class PhoneNumber {

/*  _________________________                                  ________________________  */
/*  ========================= !!! ---*** PROPERTIES ***--- !!! ========================  */


/*  -------------------         *** Instantiate Variables ***       -------------------  */


    // Fixed Fields
    String phoneNumber // 3 digits for country code, 15 digits for number
    String phoneType // e.164 Format: string https://en.wikipedia.org/wiki/E.164 Home, Work, Personal
    String phoneStatus // yes, no
    Date dateCreated
    Date expirationDate

    // Possible transient or service
    Communication lastCallAnswered //Last Action
    Communication lastCallPlaced  // Reference to linked row in call, email, or post w/ most recent timestamp
    Integer callsSinceLastAnswer
    Integer callsSinceLastResponse
    Float answerRate



    static constraints = {
    }

/*  -------------------             *** GORM Mapping ***            -------------------  */
    static hasMany = [notes: Note]
}
