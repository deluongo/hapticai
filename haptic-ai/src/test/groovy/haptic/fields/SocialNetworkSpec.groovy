package haptic.fields

import grails.test.mixin.TestFor
import haptic.connect.Communication
import haptic.connect.CommunicationSpec
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SocialNetwork)
class SocialNetworkSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test network name not blank"() {
        when: "Network name blank"
        SocialNetwork testSocialNetwork = new SocialNetwork(    networkName: '',
                                                                networkUrl: 'twitter.com',
                                                                handle: 'HarvardU',
                                                                lastActivity: new Date(),
                                                                lastPost: new Communication(),
                                                                posts: new HashSet<Communication>(),
                                                                lastOnline: new Date())

        then: "Fail validation"
            !testSocialNetwork.validate()

    }

    void "Test handle not blank"() {
        when: "Handle blank"
        SocialNetwork testSocialNetwork = new SocialNetwork(    networkName: 'Twitter',
                                                                networkUrl: 'twitter.com',
                                                                handle: '',
                                                                lastActivity: new Date(),
                                                                lastPost: new Communication(),
                                                                posts: new HashSet<Communication>(),
                                                                lastOnline: new Date())

        then: "Fail validation"
            !testSocialNetwork.validate()

    }

    void "Test network URL in proper format"() {
        when:"network URL not in proper format"
        SocialNetwork testSocialNetwork = new SocialNetwork(    networkName: 'Twitter',
                                                                networkUrl: '',
                                                                handle: '',
                                                                lastActivity: new Date(),
                                                                lastPost: new Communication(),
                                                                posts: new HashSet<Communication>(),
                                                                lastOnline: new Date())

        then:"Fail validation"
            !testSocialNetwork.validate()
    }
}
