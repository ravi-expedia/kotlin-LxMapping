

import DataAccess.ActivityComponent
import org.w3c.dom.Element
import java.io.File
import kotlin.dom.parseXml
import kotlin.dom.xpath.evaluateIterator
import kotlin.dom.xpath.filterIsElement

fun main(args: Array<String>) {
//    parseXml(File(".idea/gradle.xml"))
//            .evaluateIterator("//Trip/TripKey/TripID")
//            .sequence()
//            .filterIsElement()
//            .forEach {
////                val name = it.getAttribute("name")
////                val value = it.getAttribute("value")
////
////                println("$name = $value")
//                println(it.getTextContent());
//            }
    val activityComponent = ActivityComponent()
    println(activityComponent.getTripId())
    println("abc");
    println(activityComponent.getTripNumber())
    println(activityComponent.getTripTitle())
//    println(activityComponent.getStartDate())
//    println(activityComponent.getStartTime())
    println(activityComponent.getWebDetailsURL())
    println(activityComponent.getUpdateTripNameDescPathURL())
    println(activityComponent.getVoucherBarCode())
    println(activityComponent.getVoucherSecurityCode())
    println(activityComponent.getRedemptionInstructions())


}