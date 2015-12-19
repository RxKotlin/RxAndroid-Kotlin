package com.github.rxkotlin.rxandroid_kotlin.widget

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import rx.Observable
import rx.subjects.BehaviorSubject

fun EditText.onTextChanged() : Observable<String> {
    val subject = BehaviorSubject.create<String>();
    this.addTextChangedListener(object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            subject.onNext(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun afterTextChanged(s: Editable) {}
    })
    return subject
}

fun EditText.beforeTextChanged() : Observable<String> {
    val subject = BehaviorSubject.create<String>();
    this.addTextChangedListener(object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            subject.onNext(s.toString())
        }

        override fun afterTextChanged(s: Editable) {}
    })
    return subject
}

fun EditText.afterTextChanged() : Observable<String> {
    val subject = BehaviorSubject.create<String>();
    this.addTextChangedListener(object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun afterTextChanged(s: Editable) {
            subject.onNext(s.toString())
        }
    })
    return subject
}
