package oncall.model.mock

import oncall.model.Date
import oncall.model.Month
import oncall.model.Person
import oncall.model.Weekday
import oncall.model.WorkingGroup

val targetDate1 = Date(Month(5), weekday = Weekday.Monday)
val weekdayGroup1 = WorkingGroup(
    listOf(
        Person("준팍"),
        Person("도밥"),
        Person("고니"),
        Person("수아"),
        Person("루루"),
        Person("글로"),
        Person("솔로스타"),
        Person("우코"),
        Person("슬링키"),
        Person("참새"),
        Person("도리")
    )
)
val restDayGroup1 = WorkingGroup(
    listOf(
        Person("수아"),
        Person("루루"),
        Person("글로"),
        Person("솔로스타"),
        Person("우코"),
        Person("슬링키"),
        Person("참새"),
        Person("도리"),
        Person("준팍"),
        Person("도밥"),
        Person("고니"),
    )
)
val sheetResult1 = listOf(
    Person(name = "준팍"),
    Person(name = "도밥"),
    Person(name = "고니"),
    Person(name = "수아"),
    Person(name = "루루"),
    Person(name = "수아"),
    Person(name = "글로"),
    Person(name = "루루"),
    Person(name = "글로"),
    Person(name = "솔로스타"),
    Person(name = "우코"),
    Person(name = "슬링키"),
    Person(name = "솔로스타"),
    Person(name = "우코"),
    Person(name = "참새"),
    Person(name = "도리"),
    Person(name = "준팍"),
    Person(name = "도밥"),
    Person(name = "고니"),
    Person(name = "슬링키"),
    Person(name = "참새"),
    Person(name = "수아"),
    Person(name = "루루"),
    Person(name = "글로"),
    Person(name = "솔로스타"),
    Person(name = "우코"),
    Person(name = "도리"),
    Person(name = "준팍"),
    Person(name = "슬링키"),
    Person(name = "참새"),
    Person(name = "도리"),
)