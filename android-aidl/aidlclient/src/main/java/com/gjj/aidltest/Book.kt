package com.gjj.aidltest

import android.os.Parcel
import android.os.Parcelable

/**
 * author: gujingjing
 * created on: 2020/10/19 4:28 PM
 * description:
 */
class Book() : Parcelable {
    var bookName: String = ""

    var bookId: Long = 0L

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Book> = object : Parcelable.Creator<Book> {
            override fun createFromParcel(source: Parcel): Book = Book(source)
            override fun newArray(size: Int): Array<Book?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this() {
        this.bookName = source.readString() ?: ""
        this.bookId = source.readLong()
    }


    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(bookName)
        writeLong(bookId)
    }

    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * @param dest
     */
    fun readFromParcel(dest: Parcel) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        bookName = dest.readString() ?: ""
        bookId = dest.readLong()
    }
}