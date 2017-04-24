package haptic.fields

import grails.test.mixin.TestFor
import haptic.connect.Call
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PhoneNumber)
class PhoneNumberSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test phoneNumber in proper format"() {
        when:"Phone number not in proper format"
            PhoneNumber testPhoneNumber = new PhoneNumber(  phoneNumber: '',
                                                            phoneType: 'Work',
                                                            primary: true,
                                                            dateCreated: new Date(),
                                                            lastCallAnswered: new Call(),
                                                            lastCallPlaced: new Call())

        then:"Fail validation"
            !testPhoneNumber.validate()
    }
}
