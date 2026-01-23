package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextViewKt {

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$1 */
    /* JADX INFO: compiled from: TextView.kt */
    public static final class C03041 extends Lambda implements Function4<CharSequence, Integer, Integer, Integer, Unit> {
        public static final C03041 INSTANCE = new C03041();

        public C03041() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.f27425a;
        }

        public final void invoke(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$2 */
    /* JADX INFO: compiled from: TextView.kt */
    public static final class C03052 extends Lambda implements Function4<CharSequence, Integer, Integer, Integer, Unit> {
        public static final C03052 INSTANCE = new C03052();

        public C03052() {
            super(4);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
            invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            return Unit.f27425a;
        }

        public final void invoke(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: androidx.core.widget.TextViewKt$addTextChangedListener$3 */
    /* JADX INFO: compiled from: TextView.kt */
    public static final class C03063 extends Lambda implements Function1<Editable, Unit> {
        public static final C03063 INSTANCE = new C03063();

        public C03063() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
            function4 = C03041.INSTANCE;
        }
        if ((i & 2) != 0) {
            function42 = C03052.INSTANCE;
        }
        if ((i & 4) != 0) {
            function1 = C03063.INSTANCE;
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
        C0307xbb2cb19c c0307xbb2cb19c = new C0307xbb2cb19c(function1);
        textView.addTextChangedListener(c0307xbb2cb19c);
        return c0307xbb2cb19c;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics3.checkNotNullParameter(textView, "<this>");
        Intrinsics3.checkNotNullParameter(function4, "action");
        C0308x44bcd5b1 c0308x44bcd5b1 = new C0308x44bcd5b1(function4);
        textView.addTextChangedListener(c0308x44bcd5b1);
        return c0308x44bcd5b1;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        Intrinsics3.checkNotNullParameter(textView, "<this>");
        Intrinsics3.checkNotNullParameter(function4, "action");
        C0309x3fe43951 c0309x3fe43951 = new C0309x3fe43951(function4);
        textView.addTextChangedListener(c0309x3fe43951);
        return c0309x3fe43951;
    }
}
