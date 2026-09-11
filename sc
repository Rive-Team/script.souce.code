local Ids = {
    ["1990424117"] = "9999/99/99 99:99:99",
    ["3107357668"]  = "9999/99/99 99:99:99",
    ["4543428368"] = "9999/99/99 99:99:99",
    ["5787454361"] = "9999/99/99 99:99:99",
    ["7005522439"] = "9999/99/99 99:99:99",
    ["2849293624"] = "9999/99/99 99:99:99",
    [""] = "9999/99/99 99:99:99",
    [""] = "9999/99/99 99:99:99",
    [""] = "9999/99/99 99:99:99",
    [""] = "9999/99/99 99:99:99",
    [""] = "9999/99/99 99:99:99",
    [""] = "9999/99/99 99:99:99",
    [""] = "9999/99/99 99:99:99",
    [""] = "9999/99/99 99:99:99",
}

local PremiumUsers = {}

local function FetchDateTime(DateTimeStr)
    local Year, Month, Day, Hour, Min, Sec = string.match(DateTimeStr, "(%d+)%/(%d+)%/(%d+)%s+(%d+):(%d+):(%d+)")
    return tonumber(string.format("%04d%02d%02d%02d%02d%02d", Year, Month, Day, Hour, Min, Sec))
end

local CurrentTime = os.date("*t")
local CurrentCompare = tonumber(string.format(
    "%04d%02d%02d%02d%02d%02d",
    CurrentTime.year,
    CurrentTime.month,
    CurrentTime.day,
    CurrentTime.hour,
    CurrentTime.min,
    CurrentTime.sec
))

for ID, Date in pairs(Ids) do
    local IDDateCompare = FetchDateTime(Date)
    if IDDateCompare > CurrentCompare then
        table.insert(PremiumUsers, tostring(ID))
    end
end

return PremiumUsers
