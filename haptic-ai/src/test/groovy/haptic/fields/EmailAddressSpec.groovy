package haptic.fields

import grails.test.mixin.TestFor
import haptic.connect.Communication
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(EmailAddress)
class EmailAddressSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test email in proper format"() {
        when: "Email not in proper format"
            EmailAddress testEmailAddress = new EmailAddress(   emailType: "School",
                                                                emailAddress: "bob@harvard.eduedueduedu",
                                                                emailExtension: "@harvard.edu",
                                                                primary: true,
                                                                emailStatus: 'unverified',
                                                                unsubscribed: false,
                                                                lastEmailAnswered: new Communication(),
                                                                lastEmailSent: new Communication())

        then: "Fail validation"
            !testEmailAddress.validate()
    }

    void "Test emailStatus is valid"() {
        when: "Email status not valid"
            EmailAddress testEmailAddress = new EmailAddress(   emailType: "School",
                                                                emailAddress: "bob@harvard.edu",
                                                                emailExtension: "@harvard.edu",
                                                                primary: true,
                                                                emailStatus: '',
                                                                unsubscribed: false,
                                                                lastEmailAnswered: new Communication(),
                                                                lastEmailSent: new Communication())

        then: "Fail validation"
            !testEmailAddress.validate()
    }


}
