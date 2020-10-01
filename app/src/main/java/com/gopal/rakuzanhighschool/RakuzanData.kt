package com.gopal.rakuzanhighschool

object RakuzanData {

    private val dataTitle = arrayOf(
        "Seijūrō Akashi",
        "Reo Mibuchi",
        "Kotarō Hayama",
        "Eikichi Nebuya",
        "Chihiro Mayuzumi"
    )

    private val dataDesc = arrayOf(
        "#4 // PG",
        "#6 // SG",
        "#7 // SF",
        "#8 // C",
        "#5 // PF"
    )

    private val dataImg = intArrayOf(
        R.drawable.akashi,
        R.drawable.mibuchi,
        R.drawable.kotaro,
        R.drawable.eikichi,
        R.drawable.mayuzumi
    )

    val listData : ArrayList<Rakuzan>

    get() {
        val list = ArrayList<Rakuzan>()

        for (position in dataTitle.indices){
            val rakuzan = Rakuzan().apply {
                title = dataTitle[position]
                desc = dataDesc[position]
                img = dataImg[position]
            }

            list.add(rakuzan)
        }
        return list
    }

}