package com.discord.utilities.textprocessing;

import android.content.Context;
import android.content.res.Resources;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.t.m;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: ChangelogSpans.kt */
/* loaded from: classes2.dex */
public final class ChangelogSpans {
    public static final ChangelogSpans INSTANCE = new ChangelogSpans();
    private static final int MARKDOWN_BULLET_RADIUS = 8;

    /* compiled from: ChangelogSpans.kt */
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createChangelogSpecialHeaderPaddingSpansProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<List<? extends VerticalPaddingSpan>> {
        public final /* synthetic */ int $headerBottomPx;
        public final /* synthetic */ int $headerTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, int i2) {
            super(0);
            this.$headerTopPx = i;
            this.$headerBottomPx = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends VerticalPaddingSpan> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends VerticalPaddingSpan> invoke2() {
            return m.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
        }
    }

    /* compiled from: ChangelogSpans.kt */
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderClassSpanProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ int $marginTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, int i) {
            super(1);
            this.$context = context;
            this.$marginTopPx = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(String str) {
            return invoke2(str);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(String str) {
            d0.z.d.m.checkNotNullParameter(str, "className");
            switch (str.hashCode()) {
                case -1269237627:
                    if (str.equals("changelogSpecial")) {
                        return new TextAppearanceSpan(this.$context, 2131952041);
                    }
                    return null;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        return new VerticalPaddingSpan(0, this.$marginTopPx);
                    }
                    return null;
                case -1001078227:
                    if (str.equals("progress")) {
                        return new TextAppearanceSpan(this.$context, 2131952039);
                    }
                    return null;
                case -419685396:
                    if (str.equals("improved")) {
                        return new TextAppearanceSpan(this.$context, 2131952038);
                    }
                    return null;
                case 92659968:
                    if (str.equals("added")) {
                        return new TextAppearanceSpan(this.$context, 2131952036);
                    }
                    return null;
                case 97445748:
                    if (str.equals("fixed")) {
                        return new TextAppearanceSpan(this.$context, 2131952037);
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    /* compiled from: ChangelogSpans.kt */
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderPaddingSpansProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<List<? extends VerticalPaddingSpan>> {
        public final /* synthetic */ int $headerBottomPx;
        public final /* synthetic */ int $headerTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, int i2) {
            super(0);
            this.$headerTopPx = i;
            this.$headerBottomPx = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends VerticalPaddingSpan> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends VerticalPaddingSpan> invoke2() {
            return m.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
        }
    }

    /* compiled from: ChangelogSpans.kt */
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderStyleSpanProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, CharacterStyle> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharacterStyle invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharacterStyle invoke(int i) {
            return i != 1 ? i != 4 ? new StyleSpan(3) : new TextAppearanceSpan(this.$context, 2131952040) : new TextAppearanceSpan(this.$context, 2131952035);
        }
    }

    /* compiled from: ChangelogSpans.kt */
    /* renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createSpecialHeaderStyleSpanProvider$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, CharacterStyle> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharacterStyle invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharacterStyle invoke(int i) {
            return i != 1 ? i != 4 ? new StyleSpan(3) : new TextAppearanceSpan(this.$context, 2131952040) : new TextAppearanceSpan(this.$context, 2131952041);
        }
    }

    private ChangelogSpans() {
    }

    public final Function0<List<VerticalPaddingSpan>> createChangelogSpecialHeaderPaddingSpansProvider(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_changelog_special_top_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_bottom_padding));
    }

    public final Function1<String, Object> createHeaderClassSpanProvider(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context, context.getResources().getDimensionPixelSize(R.dimen.markdown_header_class_marginTop));
    }

    public final Function0<List<VerticalPaddingSpan>> createHeaderPaddingSpansProvider(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_top_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_bottom_padding));
    }

    public final Function1<Integer, CharacterStyle> createHeaderStyleSpanProvider(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context);
    }

    public final Function0<List<ParagraphStyle>> createMarkdownBulletSpansProvider(Context context) throws Resources.NotFoundException {
        d0.z.d.m.checkNotNullParameter(context, "context");
        return new ChangelogSpans$createMarkdownBulletSpansProvider$1$1(context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_vertical_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_gap), ColorCompat.getThemedColor(context, R.attr.color_brand_500));
    }

    public final Function1<Integer, CharacterStyle> createSpecialHeaderStyleSpanProvider(Context context) {
        d0.z.d.m.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context);
    }
}
