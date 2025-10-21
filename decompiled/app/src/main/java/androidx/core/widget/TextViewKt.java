package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* compiled from: TextView.kt */
/* loaded from: classes.dex */
public final class TextViewKt {

    /* compiled from: TextView.kt */
    /* renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function4<CharSequence, Integer, Integer, Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.a;
        }

        public final void invoke(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: TextView.kt */
    /* renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function4<CharSequence, Integer, Integer, Integer, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.a;
        }

        public final void invoke(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: TextView.kt */
    /* renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Editable, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
        }
    }

    public static final TextWatcher addTextChangedListener(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function42, Function1<? super Editable, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textView, "<this>");
        Intrinsics3.checkNotNullParameter(function4, "beforeTextChanged");
        Intrinsics3.checkNotNullParameter(function42, "onTextChanged");
        Intrinsics3.checkNotNullParameter(function1, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, function4, function42);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, Function4 function4, Function4 function42, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function4 = AnonymousClass1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function42 = AnonymousClass2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function1 = AnonymousClass3.INSTANCE;
        }
        Intrinsics3.checkNotNullParameter(textView, "<this>");
        Intrinsics3.checkNotNullParameter(function4, "beforeTextChanged");
        Intrinsics3.checkNotNullParameter(function42, "onTextChanged");
        Intrinsics3.checkNotNullParameter(function1, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, function4, function42);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static final TextWatcher doAfterTextChanged(TextView textView, Function1<? super Editable, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textView, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1(function1);
        textView.addTextChangedListener(textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics3.checkNotNullParameter(textView, "<this>");
        Intrinsics3.checkNotNullParameter(function4, "action");
        TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1(function4);
        textView.addTextChangedListener(textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics3.checkNotNullParameter(textView, "<this>");
        Intrinsics3.checkNotNullParameter(function4, "action");
        TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1 = new TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1(function4);
        textView.addTextChangedListener(textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1);
        return textViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1;
    }
}
