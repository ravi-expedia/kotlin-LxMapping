package DataAccess

import org.w3c.dom.Element
import java.io.File
import java.time.LocalTime
import java.util.Date
import kotlin.dom.parseXml
import kotlin.dom.xpath.evaluateIterator
import kotlin.dom.xpath.filterIsElement


/**
 * Created by rpenta on 2/21/16.
 */

class ActivityComponent{
    val fileHandler = File(".idea/gradle.xml")
    val HOSTNAME = "localhost:8080"

    fun getTripId():String {
        getElementFromFile("//Trip/TripKey/TripID")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getTripNumber():Long {
        getElementFromFile("//Trip/TripKey/TripNumber")
                .forEach {
                    return (it.getTextContent().toLong());
                }
        return 0L
    }

    fun getTripTitle(): String {
        getElementFromFile("//Trip/Title")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getWebDetailsURL():String{
        return HOSTNAME + "/trips/" + getTripNumber()
    }

    fun getUpdateTripNameDescPathURL():String {
        return HOSTNAME + "/api/trips/" + getTripId() + "/updateTripNameDescription"
    }

    fun getStartDate(): Date {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityStartDateTimeInformation/Date")
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getStartTime(): LocalTime {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityStartDateTimeInformation/Time")
                .forEach {
                    val hms : Array<String>  = it.getTextContent().split(":")

                    return (LocalTime.of(hms.get(0).toInt(),hms.get(1).toInt(),hms.get(2).toInt()))
                }
        return (LocalTime.now())
    }

    fun getEndDate(): Date {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityEndDateTimeInformation/Date")
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getEndTime(): LocalTime {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityEndDateTimeInformation/Time")
                .forEach {
                    val hms : Array<String>  = it.getTextContent().split(":")

                    return (LocalTime.of(hms.get(0).toInt(),hms.get(1).toInt(),hms.get(2).toInt()))
                }
        return (LocalTime.now())
    }

    fun getCreateDateTime(): Date {
        getElementFromFile("//Trip/CreateDateTime")
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getUpdateDateTime(): Date {
        getElementFromFile("//Trip/UpdateDateTime")
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getLastUpdateDateTime(): Date {
        getElementFromFile("//ReadTripDataDetails/LastUpdateDateTime")
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getVoucherBarCode(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VoucherBarCode")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getVoucherSecurityCode(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherSecurityCode")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }


    fun getRedemptionInstructions(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/ModularizedContentList/ModularizedContent[ContentType='redemption_instructionsGroup']/Body")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getKnowBeforeYouGoGroup(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/ModularizedContentList/ModularizedContent[ContentType='know_before_you_goGroup']/Body")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getVendorBranchID(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VendorBranchID")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getVendorName(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VendorName")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getIsRedeemer(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/TravelerInformation/Traveler/IsRedeemer")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getFirstName(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/TravelerInformation/Traveler/Traveler/Person/PersonName/FirstName")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getMiddleName(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/TravelerInformation/Traveler/Traveler/Person/PersonName/MiddleName")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getLastName(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/TravelerInformation/Traveler/Traveler/Person/PersonName/LastName")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getTicketCount(): String {
        getElementFromFile("//TotalTicketPriceByCategory/TicketCount")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getVoucherFirstRedemptionLocation(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VoucherRedemptionInfo/VoucherRedemptionLocationList/VoucherRedemptionLocation")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getDestinationExperienceInfo(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/ActivityItem/ImageList/Image/FileURL")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getActivityItemTitleEnglish(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/ActivityItem/ActivityItemTitleEnglish")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getActivityCategoryName(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityCategory/ActivityCategoryName")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getActivityDescription(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityDescription")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getActivityTitleEnglish(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityTitleEnglish")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getActivityID(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityID")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getActivityCategoryID(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/Activity/ActivityCategory/ActivityCategoryID")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getBusinessModel(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/BusinessModel")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getOrderLineTransactionState(): String {
        getElementFromFile("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/OrderLineTransactionState")
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }
    
    fun getElementFromFile(evaluateXPath: String) :  Sequence<Element> {
        return parseXml(fileHandler)
                .evaluateIterator(evaluateXPath)
                .sequence()
                .filterIsElement()
    }
}