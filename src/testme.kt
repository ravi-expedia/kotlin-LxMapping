

import DataAccess.ActivityComponent
import org.w3c.dom.Element
import java.io.File
import kotlin.dom.parseXml
import kotlin.dom.xpath.evaluateIterator
import kotlin.dom.xpath.filterIsElement

fun main(args: Array<String>) {
    val activityComponent = ActivityComponent()
    println(activityComponent.getTripId())
    println(activityComponent.getTripNumber())
    println(activityComponent.getTripTitle())
    println(activityComponent.getStartDate())
    println(activityComponent.getStartTime())
    println(activityComponent.getWebDetailsURL())
    println(activityComponent.getUpdateTripNameDescPathURL())
    println(activityComponent.getVoucherBarCode())
    println(activityComponent.getVoucherSecurityCode())
    println(activityComponent.getRedemptionInstructions())

    println(activityComponent.getEndDate())
    println(activityComponent.getEndTime())
    println(activityComponent.getCreateDateTime())
    println(activityComponent.getUpdateDateTime())
    println(activityComponent.getLastUpdateDateTime())
    println(activityComponent.getKnowBeforeYouGoGroup())
    println(activityComponent.getVendorBranchID())
    println(activityComponent.getVendorName())
    println(activityComponent.getIsRedeemer())

    println(activityComponent.getFirstName())
    println(activityComponent.getMiddleName())
    println(activityComponent.getLastName())
    println(activityComponent.getTicketCount())
    println(activityComponent.getVoucherFirstRedemptionLocation())
    println(activityComponent.getDestinationExperienceInfo())
    println(activityComponent.getActivityItemTitleEnglish())
    println(activityComponent.getActivityCategoryName())
    println(activityComponent.getActivityDescription())

    println(activityComponent.getActivityTitleEnglish())
    println(activityComponent.getActivityID())
    println(activityComponent.getActivityCategoryID())
    println(activityComponent.getBusinessModel())
    println(activityComponent.getOrderLineTransactionState())


}