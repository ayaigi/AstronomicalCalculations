package com.example.astronomicalcalculations.intern.constellation

import com.example.lib.intern.units.Hours
import com.example.lib.intern.units.Degrees
import kotlin.math.absoluteValue


internal fun idToConst(id: Int): Constellations {
    val idVal = if(id < 100) id + 100 else id
    return when (idVal) {
        101 -> Constellations.ID101
        102 -> Constellations.ID102
        103 -> Constellations.ID103
        104 -> Constellations.ID104
        105 -> Constellations.ID105
        106 -> Constellations.ID106
        107 -> Constellations.ID107
        108 -> Constellations.ID108
        109 -> Constellations.ID109
        110 -> Constellations.ID110
        111 -> Constellations.ID111
        112 -> Constellations.ID112
        113 -> Constellations.ID113
        114 -> Constellations.ID114
        115 -> Constellations.ID115
        116 -> Constellations.ID116
        117 -> Constellations.ID117
        118 -> Constellations.ID118
        119 -> Constellations.ID119
        120 -> Constellations.ID120
        121 -> Constellations.ID121
        122 -> Constellations.ID122
        123 -> Constellations.ID123
        124 -> Constellations.ID124
        125 -> Constellations.ID125
        126 -> Constellations.ID126
        127 -> Constellations.ID127
        128 -> Constellations.ID128
        129 -> Constellations.ID129
        130 -> Constellations.ID130
        131 -> Constellations.ID131
        132 -> Constellations.ID132
        133 -> Constellations.ID133
        134 -> Constellations.ID134
        135 -> Constellations.ID135
        136 -> Constellations.ID136
        137 -> Constellations.ID137
        138 -> Constellations.ID138
        139 -> Constellations.ID139
        140 -> Constellations.ID140
        141 -> Constellations.ID141
        142 -> Constellations.ID142
        143 -> Constellations.ID143
        144 -> Constellations.ID144
        145 -> Constellations.ID145
        146 -> Constellations.ID146
        147 -> Constellations.ID147
        148 -> Constellations.ID148
        149 -> Constellations.ID149
        150 -> Constellations.ID150
        151 -> Constellations.ID151
        152 -> Constellations.ID152
        153 -> Constellations.ID153
        154 -> Constellations.ID154
        155 -> Constellations.ID155
        156 -> Constellations.ID156
        157 -> Constellations.ID157
        158 -> Constellations.ID158
        159 -> Constellations.ID159
        160 -> Constellations.ID160
        161 -> Constellations.ID161
        162 -> Constellations.ID162
        163 -> Constellations.ID163
        164 -> Constellations.ID164
        165 -> Constellations.ID165
        166 -> Constellations.ID166
        167 -> Constellations.ID167
        168 -> Constellations.ID168
        169 -> Constellations.ID169
        170 -> Constellations.ID170
        171 -> Constellations.ID171
        172 -> Constellations.ID172
        173 -> Constellations.ID173
        174 -> Constellations.ID174
        175 -> Constellations.ID175
        176 -> Constellations.ID176
        177 -> Constellations.ID177
        178 -> Constellations.ID178
        179 -> Constellations.ID179
        180 -> Constellations.ID180
        181 -> Constellations.ID181
        182 -> Constellations.ID182
        183 -> Constellations.ID183
        184 -> Constellations.ID184
        185 -> Constellations.ID185
        186 -> Constellations.ID186
        187 -> Constellations.ID187
        188 -> Constellations.ID188
        else -> throw Exception("invalid: $id") //Constellations.ID101
    }
}

internal enum class Constellations(
    val id: Int,
    val consName: String,
    val rightMin: Hours,
    val rightMax: Hours,
    val decliMin: Degrees,
    val decliMax: Degrees
) {
    ID101(
        id = 101,
        consName = "Achterdeck des Schiffs",
        rightMin = Hours.of(6, 2, 0, negative = false),
        rightMax = Hours.of(8, 27, 58, negative = false),
        decliMin = Degrees.of(51, 6, 9, negative = true),
        decliMax = Degrees.of(11, 15, 8, negative = true)
    ),
    ID102(
        id = 102,
        consName = "Adler",
        rightMin = Hours.of(18, 41, 18, negative = false),
        rightMax = Hours.of(20, 38, 44, negative = false),
        decliMin = Degrees.of(11, 51, 59, negative = true),
        decliMax = Degrees.of(18, 41, 18, negative = false)
    ),
    ID103(
        id = 103,
        consName = "Altar",
        rightMin = Hours.of(16, 34, 17, negative = false),
        rightMax = Hours.of(18, 10, 41, negative = false),
        decliMin = Degrees.of(67, 41, 26, negative = true),
        decliMax = Degrees.of(45, 29, 10, negative = true)
    ),
    ID104(
        id = 104,
        consName = "Andromeda",
        rightMin = Hours.of(22, 57, 22, negative = false),
        rightMax = Hours.of(2, 39, 33, negative = false),
        decliMin = Degrees.of(21, 40, 36, negative = false),
        decliMax = Degrees.of(53, 11, 13, negative = false)
    ),
    ID105(
        id = 105,
        consName = "Bärenhüter",
        rightMin = Hours.of(13, 35, 49, negative = false),
        rightMax = Hours.of(15, 49, 28, negative = false),
        decliMin = Degrees.of(7, 21, 38, negative = false),
        decliMax = Degrees.of(55, 2, 42, negative = false)
    ),
    ID106(
        id = 106,
        consName = "Becher",
        rightMin = Hours.of(10, 51, 6, negative = false),
        rightMax = Hours.of(11, 56, 24, negative = false),
        decliMin = Degrees.of(25, 11, 45, negative = true),
        decliMax = Degrees.of(6, 39, 44, negative = true)
    ),
    ID107(
        id = 107,
        consName = "Bildhauer",
        rightMin = Hours.of(23, 6, 43, negative = false),
        rightMax = Hours.of(1, 45, 50, negative = false),
        decliMin = Degrees.of(39, 22, 21, negative = true),
        decliMax = Degrees.of(24, 48, 14, negative = true)
    ),
    ID108(
        id = 108,
        consName = "Chamäleon",
        rightMin = Hours.of(7, 26, 37, negative = false),
        rightMax = Hours.of(13, 56, 27, negative = false),
        decliMin = Degrees.of(83, 11, 46, negative = true),
        decliMax = Degrees.of(75, 17, 24, negative = true)
    ),
    ID109(
        id = 109,
        consName = "Chemischer Ofen",
        rightMin = Hours.of(1, 45, 24, negative = false),
        rightMax = Hours.of(3, 50, 21, negative = false),
        decliMin = Degrees.of(39, 30, 46, negative = true),
        decliMax = Degrees.of(23, 45, 23, negative = true)
    ),
    ID110(
        id = 110,
        consName = "Delphin",
        rightMin = Hours.of(20, 14, 14, negative = false),
        rightMax = Hours.of(21, 8, 0, negative = false),
        decliMin = Degrees.of(2, 24, 8, negative = false),
        decliMax = Degrees.of(20, 56, 24, negative = false)
    ),
    ID111(
        id = 111,
        consName = "Drache",
        rightMin = Hours.of(9, 22, 28, negative = false),
        rightMax = Hours.of(20, 54, 49, negative = false),
        decliMin = Degrees.of(47, 32, 51, negative = false),
        decliMax = Degrees.of(86, 27, 56, negative = false)
    ),
    ID112(
        id = 112,
        consName = "Dreieck",
        rightMin = Hours.of(1, 31, 28, negative = false),
        rightMax = Hours.of(2, 50, 40, negative = false),
        decliMin = Degrees.of(25, 36, 18, negative = false),
        decliMax = Degrees.of(37, 20, 50, negative = false)
    ),
    ID113(
        id = 113,
        consName = "Eidechse",
        rightMin = Hours.of(21, 57, 30, negative = false),
        rightMax = Hours.of(22, 57, 52, negative = false),
        decliMin = Degrees.of(35, 9, 56, negative = false),
        decliMax = Degrees.of(56, 55, 5, negative = false)
    ),
    ID114(
        id = 114,
        consName = "Einhorn",
        rightMin = Hours.of(5, 55, 52, negative = false),
        rightMax = Hours.of(8, 11, 24, negative = false),
        decliMin = Degrees.of(11, 22, 8, negative = true),
        decliMax = Degrees.of(11, 56, 0, negative = false)
    ),
    ID115(
        id = 115,
        consName = "Eridanus",
        rightMin = Hours.of(1, 24, 49, negative = false),
        rightMax = Hours.of(5, 11, 13, negative = false),
        decliMin = Degrees.of(57, 54, 58, negative = true),
        decliMax = Degrees.of(0, 24, 13, negative = false)
    ),
    ID116(
        id = 116,
        consName = "Fische",
        rightMin = Hours.of(22, 51, 17, negative = false),
        rightMax = Hours.of(2, 6, 40, negative = false),
        decliMin = Degrees.of(6, 18, 27, negative = true),
        decliMax = Degrees.of(33, 40, 55, negative = false)
    ),
    ID117(
        id = 117,
        consName = "Fliege",
        rightMin = Hours.of(11, 19, 26, negative = false),
        rightMax = Hours.of(13, 51, 8, negative = false),
        decliMin = Degrees.of(75, 41, 46, negative = true),
        decliMax = Degrees.of(64, 38, 17, negative = true)
    ),
    ID118(
        id = 118,
        consName = "Fliegender Fisch",
        rightMin = Hours.of(6, 31, 5, negative = false),
        rightMax = Hours.of(9, 4, 23, negative = false),
        decliMin = Degrees.of(75, 29, 44, negative = true),
        decliMax = Degrees.of(64, 6, 25, negative = true)
    ),
    ID119(
        id = 119,
        consName = "Fuchs",
        rightMin = Hours.of(18, 57, 7, negative = false),
        rightMax = Hours.of(21, 30, 39, negative = false),
        decliMin = Degrees.of(19, 23, 54, negative = false),
        decliMax = Degrees.of(29, 29, 14, negative = false)
    ),
    ID120(
        id = 120,
        consName = "Fuhrmann",
        rightMin = Hours.of(4, 37, 54, negative = false),
        rightMax = Hours.of(7, 30, 56, negative = false),
        decliMin = Degrees.of(27, 53, 29, negative = false),
        decliMax = Degrees.of(56, 9, 53, negative = false)
    ),
    ID121(
        id = 121,
        consName = "Füllen",
        rightMin = Hours.of(20, 56, 11, negative = false),
        rightMax = Hours.of(21, 26, 20, negative = false),
        decliMin = Degrees.of(2, 28, 38, negative = false),
        decliMax = Degrees.of(13, 2, 21, negative = false)
    ),
    ID122(
        id = 122,
        consName = "Giraffe",
        rightMin = Hours.of(3, 15, 36, negative = false),
        rightMax = Hours.of(14, 27, 8, negative = false),
        decliMin = Degrees.of(52, 39, 56, negative = false),
        decliMax = Degrees.of(86, 5, 51, negative = false)
    ),
    ID123(
        id = 123,
        consName = "Grabstichel",
        rightMin = Hours.of(4, 19, 32, negative = false),
        rightMax = Hours.of(5, 5, 1, negative = false),
        decliMin = Degrees.of(48, 44, 18, negative = true),
        decliMax = Degrees.of(27, 1, 30, negative = true)
    ),
    ID124(
        id = 124,
        consName = "Großer Bär",
        rightMin = Hours.of(8, 8, 31, negative = false),
        rightMax = Hours.of(14, 29, 0, negative = false),
        decliMin = Degrees.of(28, 18, 14, negative = false),
        decliMax = Degrees.of(73, 8, 18, negative = false)
    ),
    ID125(
        id = 125,
        consName = "Großer Hund",
        rightMin = Hours.of(6, 11, 36, negative = false),
        rightMax = Hours.of(7, 27, 54, negative = false),
        decliMin = Degrees.of(33, 15, 2, negative = true),
        decliMax = Degrees.of(11, 1, 49, negative = true)
    ),
    ID126(
        id = 126,
        consName = "Haar der Berenike",
        rightMin = Hours.of(11, 58, 25, negative = false),
        rightMax = Hours.of(13, 36, 7, negative = false),
        decliMin = Degrees.of(13, 18, 14, negative = false),
        decliMax = Degrees.of(33, 18, 27, negative = false)
    ),
    ID127(
        id = 127,
        consName = "Hase",
        rightMin = Hours.of(4, 55, 2, negative = false),
        rightMax = Hours.of(6, 12, 52, negative = false),
        decliMin = Degrees.of(27, 16, 44, negative = true),
        decliMax = Degrees.of(10, 48, 50, negative = true)
    ),
    ID128(
        id = 128,
        consName = "Herkules",
        rightMin = Hours.of(15, 48, 30, negative = false),
        rightMax = Hours.of(18, 57, 50, negative = false),
        decliMin = Degrees.of(3, 40, 25, negative = false),
        decliMax = Degrees.of(51, 19, 27, negative = false)
    ),
    ID129(
        id = 129,
        consName = "Indianer",
        rightMin = Hours.of(20, 28, 41, negative = false),
        rightMax = Hours.of(23, 27, 59, negative = false),
        decliMin = Degrees.of(74, 27, 16, negative = true),
        decliMax = Degrees.of(44, 57, 32, negative = true)
    ),
    ID130(
        id = 130,
        consName = "Jagdhunde",
        rightMin = Hours.of(12, 6, 22, negative = false),
        rightMax = Hours.of(14, 7, 33, negative = false),
        decliMin = Degrees.of(27, 50, 38, negative = false),
        decliMax = Degrees.of(52, 21, 35, negative = false)
    ),
    ID131(
        id = 131,
        consName = "Jungfrau",
        rightMin = Hours.of(11, 37, 22, negative = false),
        rightMax = Hours.of(15, 11, 25, negative = false),
        decliMin = Degrees.of(22, 40, 38, negative = true),
        decliMax = Degrees.of(14, 21, 38, negative = false)
    ),
    ID132(
        id = 132,
        consName = "Kassiopeia",
        rightMin = Hours.of(22, 57, 5, negative = false),
        rightMax = Hours.of(3, 41, 14, negative = false),
        decliMin = Degrees.of(46, 40, 33, negative = false),
        decliMax = Degrees.of(77, 41, 32, negative = false)
    ),
    ID133(
        id = 133,
        consName = "Kepheus",
        rightMin = Hours.of(20, 1, 56, negative = false),
        rightMax = Hours.of(9, 3, 20, negative = false),
        decliMin = Degrees.of(53, 21, 12, negative = false),
        decliMax = Degrees.of(88, 41, 46, negative = false)
    ),
    ID134(
        id = 134,
        consName = "Kiel des Schiffs",
        rightMin = Hours.of(6, 2, 46, negative = false),
        rightMax = Hours.of(11, 20, 37, negative = false),
        decliMin = Degrees.of(75, 41, 2, negative = true),
        decliMax = Degrees.of(50, 45, 16, negative = true)
    ),
    ID135(
        id = 135,
        consName = "Kleine Wasserschlange",
        rightMin = Hours.of(0, 6, 8, negative = false),
        rightMax = Hours.of(4, 35, 11, negative = false),
        decliMin = Degrees.of(82, 3, 52, negative = true),
        decliMax = Degrees.of(57, 50, 54, negative = true)
    ),
    ID136(
        id = 136,
        consName = "Kleiner Bär",
        rightMin = Hours.of(0, 0, 0, negative = false),
        rightMax = Hours.of(24, 0, 0, negative = false),
        decliMin = Degrees.of(65, 23, 59, negative = false),
        decliMax = Degrees.of(90, 0, 0, negative = false)
    ),
    ID137(
        id = 137,
        consName = "Kleiner Hund",
        rightMin = Hours.of(7, 6, 39, negative = false),
        rightMax = Hours.of(8, 11, 41, negative = false),
        decliMin = Degrees.of(0, 22, 10, negative = false),
        decliMax = Degrees.of(13, 13, 26, negative = false)
    ),
    ID138(
        id = 138,
        consName = "Kleiner Löwe",
        rightMin = Hours.of(9, 22, 35, negative = false),
        rightMax = Hours.of(11, 6, 51, negative = false),
        decliMin = Degrees.of(22, 50, 15, negative = false),
        decliMax = Degrees.of(41, 25, 54, negative = false)
    ),
    ID139(
        id = 139,
        consName = "Kranich",
        rightMin = Hours.of(21, 27, 43, negative = false),
        rightMax = Hours.of(23, 27, 4, negative = false),
        decliMin = Degrees.of(56, 23, 27, negative = true),
        decliMax = Degrees.of(36, 18, 46, negative = true)
    ),
    ID140(
        id = 140,
        consName = "Krebs",
        rightMin = Hours.of(7, 55, 20, negative = false),
        rightMax = Hours.of(9, 22, 35, negative = false),
        decliMin = Degrees.of(6, 28, 12, negative = false),
        decliMax = Degrees.of(33, 8, 29, negative = false)
    ),
    ID141(
        id = 141,
        consName = "Kreuz des Südens",
        rightMin = Hours.of(11, 56, 14, negative = false),
        rightMax = Hours.of(12, 57, 45, negative = false),
        decliMin = Degrees.of(64, 41, 46, negative = true),
        decliMax = Degrees.of(55, 40, 38, negative = true)
    ),
    ID142(
        id = 142,
        consName = "Leier",
        rightMin = Hours.of(18, 13, 52, negative = false),
        rightMax = Hours.of(19, 28, 29, negative = false),
        decliMin = Degrees.of(25, 39, 51, negative = false),
        decliMax = Degrees.of(47, 42, 52, negative = false)
    ),
    ID143(
        id = 143,
        consName = "Löwe",
        rightMin = Hours.of(9, 21, 37, negative = false),
        rightMax = Hours.of(11, 58, 26, negative = false),
        decliMin = Degrees.of(6, 41, 30, negative = true),
        decliMax = Degrees.of(32, 58, 9, negative = false)
    ),
    ID144(
        id = 144,
        consName = "Luchs",
        rightMin = Hours.of(6, 16, 14, negative = false),
        rightMax = Hours.of(9, 42, 50, negative = false),
        decliMin = Degrees.of(32, 58, 9, negative = false),
        decliMax = Degrees.of(61, 57, 51, negative = false)
    ),
    ID145(
        id = 145,
        consName = "Luftpumpe",
        rightMin = Hours.of(9, 26, 56, negative = false),
        rightMax = Hours.of(11, 5, 55, negative = false),
        decliMin = Degrees.of(40, 25, 29, negative = true),
        decliMax = Degrees.of(24, 32, 33, negative = true)
    ),
    ID146(
        id = 146,
        consName = "Maler",
        rightMin = Hours.of(4, 32, 52, negative = false),
        rightMax = Hours.of(6, 52, 3, negative = false),
        decliMin = Degrees.of(64, 9, 7, negative = true),
        decliMax = Degrees.of(42, 47, 47, negative = true)
    ),
    ID147(
        id = 147,
        consName = "Mikroskop",
        rightMin = Hours.of(20, 27, 36, negative = false),
        rightMax = Hours.of(21, 28, 10, negative = false),
        decliMin = Degrees.of(45, 5, 24, negative = true),
        decliMax = Degrees.of(27, 27, 35, negative = true)
    ),
    ID148(
        id = 148,
        consName = "Netz",
        rightMin = Hours.of(3, 13, 27, negative = false),
        rightMax = Hours.of(4, 37, 6, negative = false),
        decliMin = Degrees.of(67, 14, 53, negative = true),
        decliMax = Degrees.of(52, 44, 49, negative = true)
    ),
    ID149(
        id = 149,
        consName = "Nördliche Krone",
        rightMin = Hours.of(15, 16, 4, negative = false),
        rightMax = Hours.of(16, 25, 7, negative = false),
        decliMin = Degrees.of(25, 32, 17, negative = false),
        decliMax = Degrees.of(39, 42, 42, negative = false)
    ),
    ID150(
        id = 150,
        consName = "Oktant",
        rightMin = Hours.of(0, 0, 0, negative = false),
        rightMax = Hours.of(24, 0, 0, negative = false),
        decliMin = Degrees.of(90, 0, 0, negative = true),
        decliMax = Degrees.of(74, 18, 14, negative = true)
    ),
    ID151(
        id = 151,
        consName = "Orion",
        rightMin = Hours.of(4, 43, 25, negative = false),
        rightMax = Hours.of(6, 25, 47, negative = false),
        decliMin = Degrees.of(10, 58, 43, negative = true),
        decliMax = Degrees.of(22, 52, 35, negative = false)
    ),
    ID152(
        id = 152,
        consName = "Paradiesvogel",
        rightMin = Hours.of(13, 49, 51, negative = false),
        rightMax = Hours.of(18, 27, 28, negative = false),
        decliMin = Degrees.of(83, 7, 12, negative = true),
        decliMax = Degrees.of(67, 28, 48, negative = true)
    ),
    ID153(
        id = 153,
        consName = "Pegasus",
        rightMin = Hours.of(21, 8, 43, negative = false),
        rightMax = Hours.of(0, 14, 58, negative = false),
        decliMin = Degrees.of(2, 19, 32, negative = false),
        decliMax = Degrees.of(36, 36, 25, negative = false)
    ),
    ID154(
        id = 154,
        consName = "Pendeluhr",
        rightMin = Hours.of(2, 12, 49, negative = false),
        rightMax = Hours.of(4, 20, 18, negative = false),
        decliMin = Degrees.of(67, 2, 9, negative = true),
        decliMax = Degrees.of(39, 38, 13, negative = true)
    ),
    ID155(
        id = 155,
        consName = "Perseus",
        rightMin = Hours.of(1, 29, 38, negative = false),
        rightMax = Hours.of(4, 51, 22, negative = false),
        decliMin = Degrees.of(30, 55, 19, negative = false),
        decliMax = Degrees.of(59, 6, 17, negative = false)
    ),
    ID156(
        id = 156,
        consName = "Pfau",
        rightMin = Hours.of(17, 40, 40, negative = false),
        rightMax = Hours.of(21, 32, 44, negative = false),
        decliMin = Degrees.of(74, 58, 28, negative = true),
        decliMax = Degrees.of(56, 35, 19, negative = true)
    ),
    ID157(
        id = 157,
        consName = "Pfeil",
        rightMin = Hours.of(18, 57, 21, negative = false),
        rightMax = Hours.of(20, 20, 45, negative = false),
        decliMin = Degrees.of(16, 4, 45, negative = false),
        decliMax = Degrees.of(21, 38, 37, negative = false)
    ),
    ID158(
        id = 158,
        consName = "Phönix",
        rightMin = Hours.of(23, 26, 46, negative = false),
        rightMax = Hours.of(2, 25, 3, negative = false),
        decliMin = Degrees.of(57, 50, 54, negative = true),
        decliMax = Degrees.of(39, 18, 14, negative = true)
    ),
    ID159(
        id = 159,
        consName = "Rabe",
        rightMin = Hours.of(11, 56, 22, negative = false),
        rightMax = Hours.of(12, 56, 40, negative = false),
        decliMin = Degrees.of(25, 11, 46, negative = true),
        decliMax = Degrees.of(11, 40, 39, negative = true)
    ),
    ID160(
        id = 160,
        consName = "Schiffskompass",
        rightMin = Hours.of(8, 26, 43, negative = false),
        rightMax = Hours.of(9, 27, 37, negative = false),
        decliMin = Degrees.of(37, 17, 31, negative = true),
        decliMax = Degrees.of(17, 24, 41, negative = true)
    ),
    ID161(
        id = 161,
        consName = "Schild",
        rightMin = Hours.of(18, 21, 36, negative = false),
        rightMax = Hours.of(18, 59, 10, negative = false),
        decliMin = Degrees.of(15, 56, 37, negative = true),
        decliMax = Degrees.of(3, 50, 1, negative = true)
    ),
    ID162(
        id = 162,
        consName = "Schlange",
        rightMin = Hours.of(15, 10, 25, negative = false),
        rightMax = Hours.of(18, 58, 18, negative = false),
        decliMin = Degrees.of(16, 8, 24, negative = true),
        decliMax = Degrees.of(25, 39, 51, negative = false)
    ),
    ID163(
        id = 163,
        consName = "Schlangenträger",
        rightMin = Hours.of(16, 1, 33, negative = false),
        rightMax = Hours.of(18, 45, 50, negative = false),
        decliMin = Degrees.of(30, 12, 44, negative = true),
        decliMax = Degrees.of(14, 23, 15, negative = false)
    ),
    ID164(
        id = 164,
        consName = "Schütze",
        rightMin = Hours.of(17, 43, 12, negative = false),
        rightMax = Hours.of(20, 28, 41, negative = false),
        decliMin = Degrees.of(45, 16, 39, negative = true),
        decliMax = Degrees.of(11, 40, 34, negative = true)
    ),
    ID165(
        id = 165,
        consName = "Schwan",
        rightMin = Hours.of(19, 7, 30, negative = false),
        rightMax = Hours.of(22, 3, 3, negative = false),
        decliMin = Degrees.of(27, 43, 57, negative = false),
        decliMax = Degrees.of(61, 21, 28, negative = false)
    ),
    ID166(
        id = 166,
        consName = "Schwertfisch",
        rightMin = Hours.of(3, 53, 17, negative = false),
        rightMax = Hours.of(6, 35, 45, negative = false),
        decliMin = Degrees.of(70, 6, 15, negative = true),
        decliMax = Degrees.of(48, 40, 12, negative = true)
    ),
    ID167(
        id = 167,
        consName = "Segel des Schiffs",
        rightMin = Hours.of(8, 3, 27, negative = false),
        rightMax = Hours.of(11, 5, 50, negative = false),
        decliMin = Degrees.of(57, 10, 28, negative = true),
        decliMax = Degrees.of(37, 9, 36, negative = true)
    ),
    ID168(
        id = 168,
        consName = "Sextant",
        rightMin = Hours.of(9, 41, 5, negative = false),
        rightMax = Hours.of(10, 51, 30, negative = false),
        decliMin = Degrees.of(11, 39, 44, negative = true),
        decliMax = Degrees.of(6, 25, 58, negative = false)
    ),
    ID169(
        id = 169,
        consName = "Skorpion",
        rightMin = Hours.of(15, 47, 15, negative = false),
        rightMax = Hours.of(17, 59, 14, negative = false),
        decliMin = Degrees.of(45, 46, 1, negative = true),
        decliMax = Degrees.of(8, 17, 45, negative = true)
    ),
    ID170(
        id = 170,
        consName = "Steinbock",
        rightMin = Hours.of(20, 6, 46, negative = false),
        rightMax = Hours.of(21, 59, 5, negative = false),
        decliMin = Degrees.of(27, 38, 31, negative = true),
        decliMax = Degrees.of(8, 24, 16, negative = true)
    ),
    ID171(
        id = 171,
        consName = "Stier",
        rightMin = Hours.of(3, 23, 21, negative = false),
        rightMax = Hours.of(6, 0, 55, negative = false),
        decliMin = Degrees.of(1, 20, 46, negative = true),
        decliMax = Degrees.of(31, 6, 1, negative = false)
    ),
    ID172(
        id = 172,
        consName = "Südliche Krone",
        rightMin = Hours.of(17, 58, 30, negative = false),
        rightMax = Hours.of(19, 19, 5, negative = false),
        decliMin = Degrees.of(45, 30, 59, negative = true),
        decliMax = Degrees.of(36, 46, 43, negative = true)
    ),
    ID173(
        id = 173,
        consName = "Südlicher Fisch",
        rightMin = Hours.of(21, 27, 14, negative = false),
        rightMax = Hours.of(23, 6, 55, negative = false),
        decliMin = Degrees.of(36, 27, 33, negative = true),
        decliMax = Degrees.of(24, 49, 30, negative = true)
    ),
    ID174(
        id = 174,
        consName = "Südliches Dreieck",
        rightMin = Hours.of(14, 56, 1, negative = false),
        rightMax = Hours.of(17, 13, 53, negative = false),
        decliMin = Degrees.of(70, 30, 42, negative = true),
        decliMax = Degrees.of(60, 15, 52, negative = true)
    ),
    ID175(
        id = 175,
        consName = "Tafelberg",
        rightMin = Hours.of(3, 12, 56, negative = false),
        rightMax = Hours.of(7, 36, 52, negative = false),
        decliMin = Degrees.of(85, 15, 41, negative = true),
        decliMax = Degrees.of(69, 44, 48, negative = true)
    ),
    ID176(
        id = 176,
        consName = "Taube",
        rightMin = Hours.of(5, 3, 54, negative = false),
        rightMax = Hours.of(6, 39, 37, negative = false),
        decliMin = Degrees.of(43, 6, 42, negative = true),
        decliMax = Degrees.of(27, 4, 38, negative = true)
    ),
    ID177(
        id = 177,
        consName = "Teleskop",
        rightMin = Hours.of(18, 9, 14, negative = false),
        rightMax = Hours.of(20, 29, 50, negative = false),
        decliMin = Degrees.of(56, 59, 2, negative = true),
        decliMax = Degrees.of(45, 5, 24, negative = true)
    ),
    ID178(
        id = 178,
        consName = "Tukan",
        rightMin = Hours.of(22, 8, 27, negative = false),
        rightMax = Hours.of(1, 24, 49, negative = false),
        decliMin = Degrees.of(75, 20, 50, negative = true),
        decliMax = Degrees.of(56, 18, 46, negative = true)
    ),
    ID179(
        id = 179,
        consName = "Waage",
        rightMin = Hours.of(14, 21, 38, negative = false),
        rightMax = Hours.of(16, 2, 17, negative = false),
        decliMin = Degrees.of(29, 59, 42, negative = true),
        decliMax = Degrees.of(0, 28, 27, negative = false)
    ),
    ID180(
        id = 180,
        consName = "Walfisch",
        rightMin = Hours.of(23, 56, 25, negative = false),
        rightMax = Hours.of(3, 23, 47, negative = false),
        decliMin = Degrees.of(24, 52, 22, negative = true),
        decliMax = Degrees.of(10, 30, 52, negative = false)
    ),
    ID181(
        id = 181,
        consName = "Wassermann",
        rightMin = Hours.of(20, 38, 19, negative = false),
        rightMax = Hours.of(23, 56, 27, negative = false),
        decliMin = Degrees.of(24, 54, 15, negative = true),
        decliMax = Degrees.of(3, 19, 32, negative = false)
    ),
    ID182(
        id = 182,
        consName = "Wasserschlange",
        rightMin = Hours.of(8, 10, 56, negative = false),
        rightMax = Hours.of(15, 2, 31, negative = false),
        decliMin = Degrees.of(35, 41, 46, negative = true),
        decliMax = Degrees.of(6, 37, 49, negative = false)
    ),
    ID183(
        id = 183,
        consName = "Widder",
        rightMin = Hours.of(1, 46, 37, negative = false),
        rightMax = Hours.of(3, 29, 42, negative = false),
        decliMin = Degrees.of(10, 21, 48, negative = false),
        decliMax = Degrees.of(31, 13, 17, negative = false)
    ),
    ID184(
        id = 184,
        consName = "Winkelmaß",
        rightMin = Hours.of(15, 12, 14, negative = false),
        rightMax = Hours.of(16, 36, 8, negative = false),
        decliMin = Degrees.of(60, 26, 8, negative = true),
        decliMax = Degrees.of(42, 16, 3, negative = true)
    ),
    ID185(
        id = 185,
        consName = "Wolf",
        rightMin = Hours.of(14, 17, 48, negative = false),
        rightMax = Hours.of(16, 8, 37, negative = false),
        decliMin = Degrees.of(55, 34, 48, negative = true),
        decliMax = Degrees.of(29, 50, 16, negative = true)
    ),
    ID186(
        id = 186,
        consName = "Zentaur",
        rightMin = Hours.of(11, 5, 21, negative = false),
        rightMax = Hours.of(15, 3, 11, negative = false),
        decliMin = Degrees.of(64, 41, 45, negative = true),
        decliMax = Degrees.of(29, 59, 42, negative = true)
    ),
    ID187(
        id = 187,
        consName = "Zirkel",
        rightMin = Hours.of(13, 38, 43, negative = false),
        rightMax = Hours.of(15, 30, 22, negative = false),
        decliMin = Degrees.of(70, 37, 28, negative = true),
        decliMax = Degrees.of(55, 26, 11, negative = true)
    ),
    ID188(
        id = 188,
        consName = "Zwillinge",
        rightMin = Hours.of(6, 0, 30, negative = false),
        rightMax = Hours.of(8, 7, 58, negative = false),
        decliMin = Degrees.of(9, 48, 35, negative = false),
        decliMax = Degrees.of(35, 23, 26, negative = false)
    ),

}

private fun main1() {
    val constAlt = "" +
            "1\tAchterdeck des Schiffs\t06.02.00:08.27.58\t-51.06.09:-11.15.08\n" +
            "2\tAdler\t18.41.18:20.38.44\t-11.51.59:+18.41.18\n" +
            "3\tAltar\t16.34.17:18.10.41\t-67.41.26:-45.29.10\n" +
            "4\tAndromeda\t22.57.22:02.39.33\t+21.40.36:+53.11.13\n" +
            "5\tBärenhüter\t13.35.49:15.49.28\t+7.21.38:+55.02.42\n" +
            "6\tBecher\t10.51.06:11.56.24\t-25.11.45:-6.39.44\n" +
            "7\tBildhauer\t23.06.43:01.45.50\t-39.22.21:-24.48.14\n" +
            "8\tChamäleon\t07.26.37:13.56.27\t-83.11.46:-75.17.24\n" +
            "9\tChemischer Ofen\t01.45.24:03.50.21\t-39.30.46:-23.45.23\n" +
            "10\tDelphin\t20.14.14:21.08.00\t+2.24.08:+20.56.24\n" +
            "11\tDrache\t09.22.28:20.54.49\t+47.32.51:+86.27.56\n" +
            "12\tDreieck\t01.31.28:02.50.40\t+25.36.18:+37.20.50\n" +
            "13\tEidechse\t21.57.30:22.57.52\t+35.09.56:+56.55.05\n" +
            "14\tEinhorn\t05.55.52:08.11.24\t-11.22.08:+11.56.00\n" +
            "15\tEridanus\t01.24.49:05.11.13\t-57.54.58:+0.24.13\n" +
            "16\tFische\t22.51.17:02.06.40\t-6.18.27:+33.40.55\n" +
            "17\tFliege\t11.19.26:13.51.08\t-75.41.46:-64.38.17\n" +
            "18\tFliegender Fisch\t06.31.05:09.04.23\t-75.29.44:-64.06.25\n" +
            "19\tFuchs\t18.57.07:21.30.39\t+19.23.54:+29.29.14\n" +
            "20\tFuhrmann\t04.37.54:07.30.56\t+27.53.29:+56.09.53\n" +
            "21\tFüllen\t20.56.11:21.26.20\t+2.28.38:+13.02.21\n" +
            "22\tGiraffe\t03.15.36:14.27.08\t+52.39.56:+86.05.51\n" +
            "23\tGrabstichel\t04.19.32:05.05.01\t-48.44.18:-27.01.30\n" +
            "24\tGroßer Bär\t08.08.31:14.29.00\t+28.18.14:+73.08.18\n" +
            "25\tGroßer Hund\t06.11.36:07.27.54\t-33.15.02:-11.01.49\n" +
            "26\tHaar der Berenike\t11.58.25:13.36.07\t+13.18.14:+33.18.27\n" +
            "27\tHase\t04.55.02:06.12.52\t-27.16.44:-10.48.50\n" +
            "28\tHerkules\t15.48.30:18.57.50\t+3.40.25:+51.19.27\n" +
            "29\tIndianer\t20.28.41:23.27.59\t-74.27.16:-44.57.32\n" +
            "30\tJagdhunde\t12.06.22:14.07.33\t+27.50.38:+52.21.35\n" +
            "31\tJungfrau\t11.37.22:15.11.25\t-22.40.38:+14.21.38\n" +
            "32\tKassiopeia\t22.57.05:03.41.14\t+46.40.33:+77.41.32\n" +
            "33\tKepheus\t20.01.56:09.03.20\t+53.21.12:+88.41.46\n" +
            "34\tKiel des Schiffs\t06.02.46:11.20.37\t-75.41.02:-50.45.16\n" +
            "35\tKleine Wasserschlange\t00.06.08:04.35.11\t-82.03.52:-57.50.54\n" +
            "36\tKleiner Bär\t00.00.00:24.00.00\t+65.23.59:+90.00.00\n" +
            "37\tKleiner Hund\t07.06.39:08.11.41\t+0.22.10:+13.13.26\n" +
            "38\tKleiner Löwe\t09.22.35:11.06.51\t+22.50.15:+41.25.54\n" +
            "39\tKranich\t21.27.43:23.27.04\t-56.23.27:-36.18.46\n" +
            "40\tKrebs\t07.55.20:09.22.35\t+6.28.12:+33.08.29\n" +
            "41\tKreuz des Südens\t11.56.14:12.57.45\t-64.41.46:-55.40.38\n" +
            "42\tLeier\t18.13.52:19.28.29\t+25.39.51:+47.42.52\n" +
            "43\tLöwe\t09.21.37:11.58.26\t-6.41.30:+32.58.09\n" +
            "44\tLuchs\t06.16.14:09.42.50\t+32.58.09:+61.57.51\n" +
            "45\tLuftpumpe\t09.26.56:11.05.55\t-40.25.29:-24.32.33\n" +
            "46\tMaler\t04.32.52:06.52.03\t-64.09.07:-42.47.47\n" +
            "47\tMikroskop\t20.27.36:21.28.10\t-45.05.24:-27.27.35\n" +
            "48\tNetz\t03.13.27:04.37.06\t-67.14.53:-52.44.49\n" +
            "49\tNördliche Krone\t15.16.04:16.25.07\t+25.32.17:+39.42.42\n" +
            "50\tOktant\t00.00.00:24.00.00\t-90.00.00:-74.18.14\n" +
            "51\tOrion\t04.43.25:06.25.47\t-10.58.43:+22.52.35\n" +
            "52\tParadiesvogel\t13.49.51:18.27.28\t-83.07.12:-67.28.48\n" +
            "53\tPegasus\t21.08.43:00.14.58\t+2.19.32:+36.36.25\n" +
            "54\tPendeluhr\t02.12.49:04.20.18\t-67.02.09:-39.38.13\n" +
            "55\tPerseus\t01.29.38:04.51.22\t+30.55.19:+59.06.17\n" +
            "56\tPfau\t17.40.40:21.32.44\t-74.58.28:-56.35.19\n" +
            "57\tPfeil\t18.57.21:20.20.45\t+16.04.45:+21.38.37\n" +
            "58\tPhönix\t23.26.46:02.25.03\t-57.50.54:-39.18.14\n" +
            "59\tRabe\t11.56.22:12.56.40\t-25.11.46:-11.40.39\n" +
            "60\tSchiffskompass\t08.26.43:09.27.37\t-37.17.31:-17.24.41\n" +
            "61\tSchild\t18.21.36:18.59.10\t-15.56.37:-3.50.01\n" +
            "62\tSchlange\t15.10.25:18.58.18\t-16.08.24:+25.39.51\n" +
            "63\tSchlangenträger\t16.01.33:18.45.50\t-30.12.44:+14.23.15\n" +
            "64\tSchütze\t17.43.12:20.28.41\t-45.16.39:-11.40.34\n" +
            "65\tSchwan\t19.07.30:22.03.03\t+27.43.57:+61.21.28\n" +
            "66\tSchwertfisch\t03.53.17:06.35.45\t-70.06.15:-48.40.12\n" +
            "67\tSegel des Schiffs\t08.03.27:11.05.50\t-57.10.28:-37.09.36\n" +
            "68\tSextant\t09.41.05:10.51.30\t-11.39.44:+6.25.58\n" +
            "69\tSkorpion\t15.47.15:17.59.14\t-45.46.01:-8.17.45\n" +
            "70\tSteinbock\t20.06.46:21.59.05\t-27.38.31:-8.24.16\n" +
            "71\tStier\t03.23.21:06.00.55\t-1.20.46:+31.06.01\n" +
            "72\tSüdliche Krone\t17.58.30:19.19.05\t-45.30.59:-36.46.43\n" +
            "73\tSüdlicher Fisch\t21.27.14:23.06.55\t-36.27.33:-24.49.30\n" +
            "74\tSüdliches Dreieck\t14.56.01:17.13.53\t-70.30.42:-60.15.52\n" +
            "75\tTafelberg\t03.12.56:07.36.52\t-85.15.41:-69.44.48\n" +
            "76\tTaube\t05.03.54:06.39.37\t-43.06.42:-27.04.38\n" +
            "77\tTeleskop\t18.09.14:20.29.50\t-56.59.02:-45.05.24\n" +
            "78\tTukan\t22.08.27:01.24.49\t-75.20.50:-56.18.46\n" +
            "79\tWaage\t14.21.38:16.02.17\t-29.59.42:-0.28.27\n" +
            "80\tWalfisch\t23.56.25:03.23.47\t-24.52.22:+10.30.52\n" +
            "81\tWassermann\t20.38.19:23.56.27\t-24.54.15:+3.19.32\n" +
            "82\tWasserschlange\t08.10.56:15.02.31\t-35.41.46:+6.37.49\n" +
            "83\tWidder\t01.46.37:03.29.42\t+10.21.48:+31.13.17\n" +
            "84\tWinkelmaß\t15.12.14:16.36.08\t-60.26.08:-42.16.03\n" +
            "85\tWolf\t14.17.48:16.08.37\t-55.34.48:-29.50.16\n" +
            "86\tZentaur\t11.05.21:15.03.11\t-64.41.45:-29.59.42\n" +
            "87\tZirkel\t13.38.43:15.30.22\t-70.37.28:-55.26.11\n" +
            "88\tZwillinge\t06.00.30:08.07.58\t+9.48.35:+35.23.26"

    val listAlt = constAlt.split("\n")
    var result: String
    var degList: List<String>
    var ListPart: List<String>
    var values: List<String>
    var negativ: Boolean
    var int: Int
    for (entry in listAlt) {
        values = entry.split("\t")
        //println(values[0].toInt())
        result = "id = ${100 + values[0].toInt()}, name = \"${values[1]}\""
        ListPart = values[2].split(':')
        degList = ListPart[0].split('.')
        int = degList[0].toInt()
        negativ = int < 0
        result += ", rightMin = Hours.of(${int.absoluteValue}, ${degList[1].toInt()}, ${degList[2].toInt()}, negative = $negativ)"

        degList = ListPart[1].split('.')
        int = degList[0].toInt()
        negativ = int < 0
        result += ", rightMax = Hours.of(${int.absoluteValue}, ${degList[1].toInt()}, ${degList[2].toInt()}, negative = $negativ)"


        ListPart = values[3].split(':')
        degList = ListPart[0].split('.')
        int = degList[0].toInt()
        negativ = int < 0
        result += ", decliMin = Degrees.of(${int.absoluteValue}, ${degList[1].toInt()}, ${degList[2].toInt()}, negative = $negativ)"

        degList = ListPart[1].split('.')
        int = degList[0].toInt()
        negativ = int < 0
        result += ", decliMax = Degrees.of(${int.absoluteValue}, ${degList[1].toInt()}, ${degList[2].toInt()}, negative = $negativ)"

        println("ID${values[0].toInt() + 100}($result),")
    }
}
private fun main2(){
    for (x in 101..188) {
        println("$x -> Constellations.ID$x")
    }
}
