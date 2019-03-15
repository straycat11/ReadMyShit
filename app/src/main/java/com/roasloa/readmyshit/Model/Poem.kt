package com.roasloa.readmyshit.Model

import android.os.Parcel
import android.os.Parcelable

class Poem(val title: String, val content: String, val image: String, var read: Int): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(image)
        parcel.writeInt(read)
    }
    override fun toString(): String {
        return title
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Poem> {
        override fun createFromParcel(parcel: Parcel): Poem {
            return Poem(parcel)
        }

        override fun newArray(size: Int): Array<Poem?> {
            return arrayOfNulls(size)
        }
    }

}