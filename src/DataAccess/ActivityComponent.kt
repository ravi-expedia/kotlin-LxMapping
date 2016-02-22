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
    fun getTripId():String
    {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/TripKey/TripID")
                .sequence()
                .filterIsElement()
                .forEach {
                    return (it.getTextContent());
                }
        return ""
    }

    fun getTripNumber():Long {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/TripKey/TripNumber")
                .sequence()
                .filterIsElement()
                .forEach {
                    return (it.getTextContent().toLong());
                }
        return 0L
    }

    fun getTripTitle(): String {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/Title")
                .sequence()
                .filterIsElement()
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
        parseXml(fileHandler)
                .evaluateIterator("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityStartDateTimeInformation/Date")
                .sequence()
                .filterIsElement()
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getStartTime(): LocalTime {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityStartDateTimeInformation/Time")
                .sequence()
                .filterIsElement()
                .forEach {
                    val hms : Array<String>  = it.getTextContent().split(":")

                    return (LocalTime.of(hms.get(0).toInt(),hms.get(1).toInt(),hms.get(2).toInt()))
                }
        return (LocalTime.now())
    }

    fun getEndDate(): Date {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityEndDateTimeInformation/Date")
                .sequence()
                .filterIsElement()
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getEndTime(): LocalTime {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/EntityList/Entity/DestinationExperienceProductEntity/ActivityEndDateTimeInformation/Time")
                .sequence()
                .filterIsElement()
                .forEach {
                    val hms : Array<String>  = it.getTextContent().split(":")

                    return (LocalTime.of(hms.get(0).toInt(),hms.get(1).toInt(),hms.get(2).toInt()))
                }
        return (LocalTime.now())
    }

    fun getCreateDateTime(): Date {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/CreateDateTime")
                .sequence()
                .filterIsElement()
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getUpdateDateTime(): Date {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/UpdateDateTime")
                .sequence()
                .filterIsElement()
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getLastUpdateDateTime(): Date {
        parseXml(fileHandler)
                .evaluateIterator("//ReadTripDataDetails/LastUpdateDateTime")
                .sequence()
                .filterIsElement()
                .forEach {
                    return (Date(it.getTextContent()));
                }
        return Date(null)
    }

    fun getVoucherBarCode(): String {
        parseXml(fileHandler)
                .evaluateIterator("//Trip/EntityList/Entity/DestinationExperienceProductEntity/DestinationExperienceItemEntity/DestinationExperienceBookedItemEntityList/DestinationExperienceBookedItemEntity/EdxItemData/VoucherInformationData/VoucherBarCode")
                .sequence()
                .filterIsElement()
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

    fun getElementFromFile(evaluateXPath: String) :  Sequence<Element> {
        return parseXml(fileHandler)
                .evaluateIterator(evaluateXPath)
                .sequence()
                .filterIsElement()
    }
}