package com.gjj.test.aidl

import android.os.Parcel
import android.os.Parcelable

/**
 * author: gujingjing
 * created on: 2020/10/19 4:28 PM
 * description:
 */
class Book() : Parcelable {
    var bookId = 0

    var bookName: String? = null

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Book> = object : Parcelable.Creator<Book> {
            override fun createFromParcel(source: Parcel): Book = Book(source)
            override fun newArray(size: Int): Array<Book?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this() {
        this.bookId = source.readInt()
        this.bookName = source.readString()
    }


    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(bookId)
        writeString(bookName)
    }
}