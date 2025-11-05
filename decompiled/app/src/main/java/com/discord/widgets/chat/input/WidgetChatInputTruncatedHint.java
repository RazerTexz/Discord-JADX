package com.discord.widgets.chat.input;

import android.text.Editable;
import android.text.TextUtils;
import com.discord.app.AppFragment;
import com.discord.utilities.view.text.TextWatcherKt;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatInputTruncatedHint.kt */
/* loaded from: classes2.dex */
public final class WidgetChatInputTruncatedHint {
    private final FlexEditText editText;
    private CharSequence hint;
    private boolean hintIsTruncated;
    private int previousMaxLines;

    /* compiled from: WidgetChatInputTruncatedHint.kt */
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            if (WidgetChatInputTruncatedHint.access$getHintIsTruncated$p(WidgetChatInputTruncatedHint.this)) {
                return;
            }
            WidgetChatInputTruncatedHint.access$setPreviousMaxLines$p(WidgetChatInputTruncatedHint.this, i);
        }
    }

    /* compiled from: WidgetChatInputTruncatedHint.kt */
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$addBindedTextWatcher$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            m.checkNotNullParameter(editable, "it");
            WidgetChatInputTruncatedHint.access$syncHint(WidgetChatInputTruncatedHint.this);
        }
    }

    public WidgetChatInputTruncatedHint(FlexEditText flexEditText) {
        m.checkNotNullParameter(flexEditText, "editText");
        this.editText = flexEditText;
        this.previousMaxLines = flexEditText.getMaxLines();
        flexEditText.setOnMaxLinesChangedListener(new AnonymousClass1());
    }

    public static final /* synthetic */ boolean access$getHintIsTruncated$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        return widgetChatInputTruncatedHint.hintIsTruncated;
    }

    public static final /* synthetic */ int access$getPreviousMaxLines$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        return widgetChatInputTruncatedHint.previousMaxLines;
    }

    public static final /* synthetic */ void access$setHintIsTruncated$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint, boolean z2) {
        widgetChatInputTruncatedHint.hintIsTruncated = z2;
    }

    public static final /* synthetic */ void access$setPreviousMaxLines$p(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint, int i) {
        widgetChatInputTruncatedHint.previousMaxLines = i;
    }

    public static final /* synthetic */ void access$syncHint(WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        widgetChatInputTruncatedHint.syncHint();
    }

    private final void syncHint() {
        boolean z2 = this.editText.length() == 0;
        this.hintIsTruncated = z2;
        if (z2) {
            this.editText.setMaxLines(1);
            this.editText.setEllipsize(TextUtils.TruncateAt.END);
            this.editText.setHint(this.hint);
        } else {
            this.editText.setMaxLines(this.previousMaxLines);
            this.editText.setEllipsize(null);
            this.editText.setHint((CharSequence) null);
        }
    }

    public final void addBindedTextWatcher(AppFragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        TextWatcherKt.addBindedTextWatcher(this.editText, fragment, new AnonymousClass1());
    }

    public final FlexEditText getEditText() {
        return this.editText;
    }

    public final void setHint(CharSequence hint) {
        m.checkNotNullParameter(hint, "hint");
        this.hint = hint;
        syncHint();
    }
}
