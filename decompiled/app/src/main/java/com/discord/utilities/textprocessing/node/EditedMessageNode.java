package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import b.a.t.b.a.a;
import com.discord.R;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.utilities.color.ColorCompat;
import d0.t.n;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EditedMessageNode.kt */
/* loaded from: classes2.dex */
public final class EditedMessageNode<RC> extends StyleNode<RC, CharacterStyle> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: EditedMessageNode.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ ForegroundColorSpan access$getForegroundColorSpan(Companion companion, Context context) {
            return companion.getForegroundColorSpan(context);
        }

        private final ForegroundColorSpan getForegroundColorSpan(Context context) {
            return new ForegroundColorSpan(ColorCompat.getThemedColor(context, R.attr.colorTextMuted));
        }

        private final RelativeSizeSpan getRelativeSizeSpan(float relativeSize) {
            return new RelativeSizeSpan(relativeSize);
        }

        public static /* synthetic */ RelativeSizeSpan getRelativeSizeSpan$default(Companion companion, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = 0.75f;
            }
            return companion.getRelativeSizeSpan(f);
        }

        public final String getEditedString(Context context) {
            m.checkNotNullParameter(context, "context");
            String string = context.getString(R.string.message_edited);
            m.checkNotNullExpressionValue(string, "context.getString(R.string.message_edited)");
            return " (" + string + ')';
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EditedMessageNode(Context context) {
        m.checkNotNullParameter(context, "context");
        Companion companion = INSTANCE;
        super(n.listOf(Companion.getRelativeSizeSpan$default(companion, 0.0f, 1, null), Companion.access$getForegroundColorSpan(companion, context)));
        addChild(new a(companion.getEditedString(context)));
    }
}
