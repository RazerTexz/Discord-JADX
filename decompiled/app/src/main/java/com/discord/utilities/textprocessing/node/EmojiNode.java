package com.discord.utilities.textprocessing.node;

import a0.a.a.b;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.a.a;
import b.f.g.a.a.d;
import b.f.g.e.v;
import com.discord.R;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.EmojiNode.RenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiNode.kt */
/* loaded from: classes2.dex */
public final class EmojiNode<T extends RenderContext> extends a<T> implements Spoilerable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int EMOJI_SIZE = DimenUtils.dpToPixels(16);
    private static final int JUMBOIFY_SCALE_FACTOR = 3;
    private final EmojiIdAndType emojiIdAndType;
    private final int height;
    private boolean isJumbo;
    private boolean isRevealed;
    private final Function3<Boolean, Integer, Context, String> urlProvider;
    private final int width;

    /* compiled from: EmojiNode.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ EmojiNode from$default(Companion companion, ModelEmojiCustom modelEmojiCustom, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = EmojiNode.access$getEMOJI_SIZE$cp();
            }
            return companion.from(modelEmojiCustom, i);
        }

        public static /* synthetic */ void renderEmoji$default(Companion companion, SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                i = EmojiNode.access$getEMOJI_SIZE$cp();
            }
            companion.renderEmoji(simpleDraweeSpanTextView, messageReactionEmoji, z2, i);
        }

        public final <T extends RenderContext> EmojiNode<T> from(ModelEmojiCustom customEmoji, int sizePx) {
            m.checkNotNullParameter(customEmoji, "customEmoji");
            String name = customEmoji.getName();
            m.checkNotNullExpressionValue(name, "customEmoji.name");
            return from(name, customEmoji.getId(), customEmoji.isAnimated(), sizePx, generateEmojiIdAndType(customEmoji));
        }

        public final EmojiIdAndType.Custom generateEmojiIdAndType(ModelEmojiCustom modelEmojiCustom) {
            m.checkNotNullParameter(modelEmojiCustom, "$this$generateEmojiIdAndType");
            long id2 = modelEmojiCustom.getId();
            boolean zIsAnimated = modelEmojiCustom.isAnimated();
            String name = modelEmojiCustom.getName();
            m.checkNotNullExpressionValue(name, "this.name");
            return new EmojiIdAndType.Custom(id2, zIsAnimated, name);
        }

        public final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2) {
            renderEmoji$default(this, simpleDraweeSpanTextView, messageReactionEmoji, z2, 0, 4, null);
        }

        public final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i) {
            String str;
            EmojiIdAndType unicode;
            String name;
            m.checkNotNullParameter(simpleDraweeSpanTextView, "$this$renderEmoji");
            str = "";
            if (messageReactionEmoji == null || !messageReactionEmoji.e()) {
                if (messageReactionEmoji != null && (name = messageReactionEmoji.getName()) != null) {
                    str = name;
                }
                unicode = new EmojiIdAndType.Unicode(str);
            } else {
                String id2 = messageReactionEmoji.getId();
                long j = id2 != null ? Long.parseLong(id2) : 0L;
                boolean animated = messageReactionEmoji.getAnimated();
                String name2 = messageReactionEmoji.getName();
                unicode = new EmojiIdAndType.Custom(j, animated, name2 != null ? name2 : "");
            }
            EmojiNode<T> emojiNodeFrom = messageReactionEmoji != null ? EmojiNode.INSTANCE.from(i, unicode) : null;
            DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
            draweeSpanStringBuilder.append((char) 8202);
            if (emojiNodeFrom == null) {
                simpleDraweeSpanTextView.setText(messageReactionEmoji != null ? messageReactionEmoji.getName() : null);
            } else {
                emojiNodeFrom.render((SpannableStringBuilder) draweeSpanStringBuilder, new EmojiNode$Companion$renderEmoji$1(simpleDraweeSpanTextView, z2));
                simpleDraweeSpanTextView.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ EmojiNode from$default(Companion companion, ModelEmojiUnicode modelEmojiUnicode, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = EmojiNode.access$getEMOJI_SIZE$cp();
            }
            return companion.from(modelEmojiUnicode, i);
        }

        public final EmojiIdAndType.Unicode generateEmojiIdAndType(ModelEmojiUnicode modelEmojiUnicode) {
            m.checkNotNullParameter(modelEmojiUnicode, "$this$generateEmojiIdAndType");
            String firstName = modelEmojiUnicode.getFirstName();
            m.checkNotNullExpressionValue(firstName, "this.firstName");
            return new EmojiIdAndType.Unicode(firstName);
        }

        public static /* synthetic */ EmojiNode from$default(Companion companion, int i, EmojiIdAndType emojiIdAndType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = EmojiNode.access$getEMOJI_SIZE$cp();
            }
            return companion.from(i, emojiIdAndType);
        }

        public final EmojiIdAndType generateEmojiIdAndType(MessageReactionEmoji messageReactionEmoji) {
            EmojiIdAndType unicode;
            m.checkNotNullParameter(messageReactionEmoji, "$this$generateEmojiIdAndType");
            if (messageReactionEmoji.e()) {
                String id2 = messageReactionEmoji.getId();
                long j = id2 != null ? Long.parseLong(id2) : 0L;
                boolean animated = messageReactionEmoji.getAnimated();
                String name = messageReactionEmoji.getName();
                unicode = new EmojiIdAndType.Custom(j, animated, name != null ? name : "");
            } else {
                String name2 = messageReactionEmoji.getName();
                unicode = new EmojiIdAndType.Unicode(name2 != null ? name2 : "");
            }
            return unicode;
        }

        public final <T extends RenderContext> EmojiNode<T> from(ModelEmojiUnicode unicodeEmoji, int sizePx) {
            m.checkNotNullParameter(unicodeEmoji, "unicodeEmoji");
            String codePoints = unicodeEmoji.getCodePoints();
            String firstName = unicodeEmoji.getFirstName();
            m.checkNotNullExpressionValue(firstName, "unicodeEmoji.firstName");
            return new EmojiNode<>(firstName, new EmojiNode$Companion$from$1(codePoints), generateEmojiIdAndType(unicodeEmoji), sizePx, sizePx);
        }

        public final EmojiIdAndType generateEmojiIdAndType(ActivityEmoji activityEmoji) throws NumberFormatException {
            EmojiIdAndType unicode;
            m.checkNotNullParameter(activityEmoji, "$this$generateEmojiIdAndType");
            if (activityEmoji.getId() != null) {
                String id2 = activityEmoji.getId();
                m.checkNotNull(id2);
                long j = Long.parseLong(id2);
                boolean animated = activityEmoji.getAnimated();
                String name = activityEmoji.getName();
                unicode = new EmojiIdAndType.Custom(j, animated, name != null ? name : "");
            } else {
                String name2 = activityEmoji.getName();
                unicode = new EmojiIdAndType.Unicode(name2 != null ? name2 : "");
            }
            return unicode;
        }

        public final <T extends RenderContext> EmojiNode<T> from(int sizePx, EmojiIdAndType emojiIdAndType) {
            m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            if (emojiIdAndType instanceof EmojiIdAndType.Unicode) {
                ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(((EmojiIdAndType.Unicode) emojiIdAndType).getName());
                if (modelEmojiUnicode != null) {
                    return EmojiNode.INSTANCE.from(modelEmojiUnicode, sizePx);
                }
                return null;
            }
            if (!(emojiIdAndType instanceof EmojiIdAndType.Custom)) {
                throw new NoWhenBranchMatchedException();
            }
            EmojiIdAndType.Custom custom = (EmojiIdAndType.Custom) emojiIdAndType;
            return from(custom.getName(), custom.getId(), custom.isAnimated(), sizePx, emojiIdAndType);
        }

        private final <T extends RenderContext> EmojiNode<T> from(String emojiName, long emojiId, boolean isAnimated, int sizePx, EmojiIdAndType emojiIdAndType) {
            return new EmojiNode<>(emojiName, new EmojiNode$Companion$from$3(emojiId, isAnimated), emojiIdAndType, sizePx, sizePx);
        }
    }

    /* compiled from: EmojiNode.kt */
    public static abstract class EmojiIdAndType implements Serializable {

        /* compiled from: EmojiNode.kt */
        public static final /* data */ class Custom extends EmojiIdAndType {
            private final long id;
            private final boolean isAnimated;
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Custom(long j, boolean z2, String str) {
                super(null);
                m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.id = j;
                this.isAnimated = z2;
                this.name = str;
            }

            public static /* synthetic */ Custom copy$default(Custom custom, long j, boolean z2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = custom.id;
                }
                if ((i & 2) != 0) {
                    z2 = custom.isAnimated;
                }
                if ((i & 4) != 0) {
                    str = custom.name;
                }
                return custom.copy(j, z2, str);
            }

            /* renamed from: component1, reason: from getter */
            public final long getId() {
                return this.id;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsAnimated() {
                return this.isAnimated;
            }

            /* renamed from: component3, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Custom copy(long id2, boolean isAnimated, String name) {
                m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return new Custom(id2, isAnimated, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Custom)) {
                    return false;
                }
                Custom custom = (Custom) other;
                return this.id == custom.id && this.isAnimated == custom.isAnimated && m.areEqual(this.name, custom.name);
            }

            public final long getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int iA = b.a(this.id) * 31;
                boolean z2 = this.isAnimated;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iA + i) * 31;
                String str = this.name;
                return i2 + (str != null ? str.hashCode() : 0);
            }

            public final boolean isAnimated() {
                return this.isAnimated;
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("Custom(id=");
                sbU.append(this.id);
                sbU.append(", isAnimated=");
                sbU.append(this.isAnimated);
                sbU.append(", name=");
                return b.d.b.a.a.J(sbU, this.name, ")");
            }
        }

        /* compiled from: EmojiNode.kt */
        public static final /* data */ class Unicode extends EmojiIdAndType {
            private final String name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Unicode(String str) {
                super(null);
                m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                this.name = str;
            }

            public static /* synthetic */ Unicode copy$default(Unicode unicode, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = unicode.name;
                }
                return unicode.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Unicode copy(String name) {
                m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return new Unicode(name);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Unicode) && m.areEqual(this.name, ((Unicode) other).name);
                }
                return true;
            }

            public final String getName() {
                return this.name;
            }

            public int hashCode() {
                String str = this.name;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return b.d.b.a.a.J(b.d.b.a.a.U("Unicode(name="), this.name, ")");
            }
        }

        private EmojiIdAndType() {
        }

        public /* synthetic */ EmojiIdAndType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmojiNode.kt */
    public interface RenderContext {

        /* compiled from: EmojiNode.kt */
        public static final class DefaultImpls {
            public static void onEmojiClicked(RenderContext renderContext, EmojiIdAndType emojiIdAndType) {
                m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            }
        }

        Context getContext();

        /* renamed from: isAnimationEnabled */
        boolean getIsAnimationEnabled();

        void onEmojiClicked(EmojiIdAndType emojiIdAndType);
    }

    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiIdAndType emojiIdAndType) {
        this(str, function3, emojiIdAndType, 0, 0, 24, null);
    }

    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiIdAndType emojiIdAndType, int i) {
        this(str, function3, emojiIdAndType, i, 0, 16, null);
    }

    public /* synthetic */ EmojiNode(String str, Function3 function3, EmojiIdAndType emojiIdAndType, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function3, emojiIdAndType, (i3 & 8) != 0 ? EMOJI_SIZE : i, (i3 & 16) != 0 ? EMOJI_SIZE : i2);
    }

    public static final /* synthetic */ int access$getEMOJI_SIZE$cp() {
        return EMOJI_SIZE;
    }

    public static final /* synthetic */ EmojiIdAndType access$getEmojiIdAndType$p(EmojiNode emojiNode) {
        return emojiNode.emojiIdAndType;
    }

    public static final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        Companion.renderEmoji$default(INSTANCE, simpleDraweeSpanTextView, messageReactionEmoji, z2, 0, 4, null);
    }

    public static final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i) {
        INSTANCE.renderEmoji(simpleDraweeSpanTextView, messageReactionEmoji, z2, i);
    }

    public boolean equals(Object other) {
        if (other instanceof EmojiNode) {
            EmojiNode emojiNode = (EmojiNode) other;
            if (m.areEqual(emojiNode.getContent(), getContent()) && emojiNode.width == this.width && emojiNode.height == this.height && emojiNode.isJumbo == this.isJumbo) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: isJumbo, reason: from getter */
    public final boolean getIsJumbo() {
        return this.isJumbo;
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    /* renamed from: isRevealed, reason: from getter */
    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    @Override // b.a.t.b.a.a, com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (RenderContext) obj);
    }

    public final void setJumbo(boolean z2) {
        this.isJumbo = z2;
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    public void setRevealed(boolean z2) {
        this.isRevealed = z2;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public void render(SpannableStringBuilder builder, T renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        Context context = renderContext.getContext();
        int length = builder.length();
        builder.append((CharSequence) getContent());
        boolean z2 = this.isJumbo;
        int i = this.width;
        if (z2) {
            i *= 3;
        }
        int i2 = i;
        int i3 = this.height;
        if (z2) {
            i3 *= 3;
        }
        int i4 = i3;
        int i5 = z2 ? 1 : 2;
        ?? A = MGImages.getImageRequest(this.urlProvider.invoke(Boolean.valueOf(renderContext.getIsAnimationEnabled()), Integer.valueOf(IconUtils.getMediaProxySize(i2)), renderContext.getContext()), 0, 0, true).a();
        d dVarA = b.f.g.a.a.b.a();
        dVarA.h = A;
        dVarA.m = getIsRevealed();
        AbstractDraweeController abstractDraweeControllerA = dVarA.a();
        b.f.g.f.a aVar = new b.f.g.f.a(context.getResources());
        aVar.f = new ColorDrawable(0);
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        aVar.n = v.l;
        if (!getIsRevealed()) {
            SpoilerNode.RenderContext renderContext2 = (SpoilerNode.RenderContext) (!(renderContext instanceof SpoilerNode.RenderContext) ? null : renderContext);
            aVar.b(new ColorDrawable(renderContext2 != null ? renderContext2.getSpoilerColorRes() : ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg)));
        }
        int length2 = builder.length() - 1;
        ((DraweeSpanStringBuilder) builder).c(context, aVar.a(), abstractDraweeControllerA, length, length2, i2, i4, false, i5);
        if (getContent().length() == 0) {
            return;
        }
        ClickableSpan clickableSpan = new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, R.attr.color_brand)), false, null, new EmojiNode$render$clickableSpan$1(this, renderContext), 4, null);
        if (length <= length2) {
            builder.setSpan(clickableSpan, length, length2 + 1, 33);
            return;
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = b.d.b.a.a.U("Span content: ");
        sbU.append(getContent());
        sbU.append('.');
        Logger.e$default(appLog, "Unable to render emoji tappable span.", new Exception(sbU.toString()), null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiIdAndType emojiIdAndType, int i, int i2) {
        super(str);
        m.checkNotNullParameter(str, "emojiName");
        m.checkNotNullParameter(function3, "urlProvider");
        m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        this.urlProvider = function3;
        this.emojiIdAndType = emojiIdAndType;
        this.width = i;
        this.height = i2;
        this.isRevealed = true;
    }
}
