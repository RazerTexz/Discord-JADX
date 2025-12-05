package com.discord.widgets.chat.input;

import android.text.Editable;
import android.text.TextUtils;
import com.discord.app.AppFragment;
import com.discord.utilities.view.text.TextWatcher4;
import com.lytefast.flexinput.widget.FlexEditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChatInputTruncatedHint.kt */
/* loaded from: classes2.dex */
public final class WidgetChatInputTruncatedHint {
    private final FlexEditText editText;
    private CharSequence hint;
    private boolean hintIsTruncated;
    private int previousMaxLines;

    /* compiled from: WidgetChatInputTruncatedHint.kt */
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$1 */
    public static final class C77551 extends Lambda implements Function1<Integer, Unit> {
        public C77551() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            if (WidgetChatInputTruncatedHint.access$getHintIsTruncated$p(WidgetChatInputTruncatedHint.this)) {
                return;
            }
            WidgetChatInputTruncatedHint.access$setPreviousMaxLines$p(WidgetChatInputTruncatedHint.this, i);
        }
    }

    /* compiled from: WidgetChatInputTruncatedHint.kt */
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInputTruncatedHint$addBindedTextWatcher$1 */
    public static final class C77561 extends Lambda implements Function1<Editable, Unit> {
        public C77561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetChatInputTruncatedHint.access$syncHint(WidgetChatInputTruncatedHint.this);
        }
    }

    public WidgetChatInputTruncatedHint(FlexEditText flexEditText) {
        Intrinsics3.checkNotNullParameter(flexEditText, "editText");
        this.editText = flexEditText;
        this.previousMaxLines = flexEditText.getMaxLines();
        flexEditText.setOnMaxLinesChangedListener(new C77551());
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
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        TextWatcher4.addBindedTextWatcher(this.editText, fragment, new C77561());
    }

    public final FlexEditText getEditText() {
        return this.editText;
    }

    public final void setHint(CharSequence hint) {
        Intrinsics3.checkNotNullParameter(hint, "hint");
        this.hint = hint;
        syncHint();
    }
}
