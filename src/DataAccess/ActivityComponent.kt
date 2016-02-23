package DataAccess

import org.w3c.dom.Element
import java.io.File
import kotlin.dom.parseXml
import kotlin.dom.xpath.evaluateIterator
import kotlin.dom.xpath.filterIsElement
import org.joda.time.DateTime
import org.joda.time.LocalTime



/**
 * Created by rpenta on 2/21/16.
 */

class ActivityComponent{
    val fileHandler = File("src/lxTrip.xml")
    val HOSTNAME = "localhost:8080"

    fun getTripId():String {
        return getElementValueFromFile("//Trip/TripKey/TripID")
    }

    fun getTripNumber():Long {
        getElementFromFile("//Trip/TripKey/TripNumber")
                .forEach {
                    return (it.getTextContent().toLong());
                }
        return 0L
    }

    fun getTripTitle(): String {
        return getElementValueFromFile("//Trip/Title")
    }

    fun getWebDetailsURL():String{
        return HOSTNAME + "/trips/" + getTripNumber()
    }

    fun getUpdateTripNameDescPathURL():String {
        return HOSTNAME + "/api/trips/" + getTripId() + "/updateTripNameDescription"
    }

    fun getStartDate(): DateTime {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityStartDateTimeInformation/Date")
                .forEach {
                    return (DateTime.parse(it.getTextContent()));
                }
        return DateTime()
    }

    fun getStartTime(): LocalTime {
        return getStartDate().toLocalTime()
    }

    fun getEndDate(): DateTime {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityEndDateTimeInformation/Date")
                .forEach {
                    return (DateTime.parse(it.getTextContent()));
                }
        return DateTime()
    }

    fun getEndTime(): LocalTime {
        return getEndDate().toLocalTime()
    }

    fun getCreateDateTime(): DateTime {
        getElementFromFile("//Trip/CreateDateTime")
                .forEach {
                    return (DateTime.parse(it.getTextContent()));
                }
        return DateTime()
    }

    fun getUpdateDateTime(): DateTime {
        getElementFromFile("//Trip/UpdateDateTime")
                .forEach {
                    return (DateTime.parse(it.getTextContent()));
                }
        return DateTime()
    }

    fun getLastUpdateDateTime(): DateTime {
        getElementFromFile("//ReadTripDataDetails/LastUpdateDateTime")
                .forEach {
                    return (DateTime.parse(it.getTextContent()));
                }
        return DateTime()
    }

    fun getVoucherBarCode(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VoucherBarCode")
    }

    fun getVoucherSecurityCode(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherSecurityCode")
    }


    fun getRedemptionInstructions(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/ModularizedContentList/ModularizedContent[ContentType='redemption_instructionsGroup']/Body")
    }

    fun getKnowBeforeYouGoGroup(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/ModularizedContentList/ModularizedContent[ContentType='know_before_you_goGroup']/Body")
    }

    fun getVendorBranchID(): Long {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VendorBranchId")
                .forEach {
                    return (it.getTextContent().toLong());
                }
        return 0L
    }

    fun getVendorName(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VendorName")
    }

    fun getIsRedeemer(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/TravelerInformation/Traveler/IsRedeemer")
    }

    fun getFirstName(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/TravelerInformation/Traveler/Traveler/Person/PersonName/FirstName")
    }

    fun getMiddleName(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/TravelerInformation/Traveler/Traveler/Person/PersonName/MiddleName")
    }

    fun getLastName(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/TravelerInformation/Traveler/Traveler/Person/PersonName/LastName")
    }

    fun getTicketCount(): String {
        return getElementValueFromFile("//TotalTicketPriceByCategory/TicketCount")
    }

    fun getVoucherFirstRedemptionLocation(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VoucherRedemptionInfo/VoucherRedemptionLocationList/VoucherRedemptionLocation")
    }

    fun getDestinationExperienceInfo(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/ActivityItem/ImageList/Image/FileURL")
    }

    fun getActivityItemTitleEnglish(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/ActivityItem/ActivityItemTitleEnglish")
    }

    fun getActivityCategoryName(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityCategory/ActivityCategoryName")
    }

    fun getActivityDescription(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityDescription")
    }

    fun getActivityTitleEnglish(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityTitleEnglish")
    }

    fun getActivityID(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityID")
    }

    fun getActivityCategoryID(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityCategory/ActivityCategoryID")
    }

    fun getBusinessModel(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/BusinessModel")
    }

    fun getOrderLineTransactionState(): String {
        return getElementValueFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/OrderLineTransactionState")
    }
    
    fun getElementFromFile(evaluateXPath: String) :  Sequence<Element> {
        return parseXml(fileHandler)
                .evaluateIterator(evaluateXPath)
                .sequence()
                .filterIsElement()
    }
    
    fun getElementValueFromFile(evaluateXPath: String) : String {
        getElementFromFile(evaluateXPath)
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }
}