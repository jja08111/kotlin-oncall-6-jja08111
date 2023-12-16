package oncall.model.mock

import oncall.model.Month
import oncall.model.Name
import oncall.model.TargetDate
import oncall.model.Weekday
import oncall.model.WorkingGroup

val targetDate1 = TargetDate(Month(5), Weekday.Monday)
val weekday1 = WorkingGroup(
    listOf(
        Name("준팍"),
        Name("도밥"),
        Name("고니"),
        Name("수아"),
        Name("루루"),
        Name("글로"),
        Name("솔로스타"),
        Name("우코"),
        Name("슬링키"),
        Name("참새"),
        Name("도리")
    )
)
val restDay1 = WorkingGroup(
    listOf(
        Name("수아"),
        Name("루루"),
        Name("글로"),
        Name("솔로스타"),
        Name("우코"),
        Name("슬링키"),
        Name("참새"),
        Name("도리"),
        Name("준팍"),
        Name("도밥"),
        Name("고니"),
    )
)
val sheetResult1 = listOf(
    Name(name = "준팍"),
    Name(name = "도밥"),
    Name(name = "고니"),
    Name(name = "수아"),
    Name(name = "루루"),
    Name(name = "수아"),
    Name(name = "글로"),
    Name(name = "루루"),
    Name(name = "글로"),
    Name(name = "솔로스타"),
    Name(name = "우코"),
    Name(name = "슬링키"),
    Name(name = "솔로스타"),
    Name(name = "우코"),
    Name(name = "참새"),
    Name(name = "도리"),
    Name(name = "준팍"),
    Name(name = "도밥"),
    Name(name = "고니"),
    Name(name = "슬링키"),
    Name(name = "참새"),
    Name(name = "수아"),
    Name(name = "루루"),
    Name(name = "글로"),
    Name(name = "솔로스타"),
    Name(name = "우코"),
    Name(name = "도리"),
    Name(name = "준팍"),
    Name(name = "슬링키"),
    Name(name = "참새"),
    Name(name = "도리"),
)