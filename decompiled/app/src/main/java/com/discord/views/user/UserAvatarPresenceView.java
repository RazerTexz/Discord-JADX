package com.discord.views.user;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import com.discord.C5419R;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.UserAvatarPresenceViewBinding;
import p007b.p008a.p062y.p072s0.UserAvatarPresenceView2;
import p007b.p008a.p062y.p072s0.UserAvatarPresenceView3;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: UserAvatarPresenceView.kt */
/* loaded from: classes2.dex */
public final class UserAvatarPresenceView extends RelativeLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final UserAvatarPresenceViewBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* renamed from: l, reason: from kotlin metadata */
    public int cutoutSpacePx;

    /* renamed from: m, reason: from kotlin metadata */
    public Function2<? super Bitmap, ? super String, Unit> onAvatarBitmapLoadedListener;

    /* compiled from: UserAvatarPresenceView.kt */
    /* renamed from: com.discord.views.user.UserAvatarPresenceView$b */
    public static final class C7132b extends Lambda implements Function2<Bitmap, String, Unit> {

        /* renamed from: j */
        public static final C7132b f19360j = new C7132b();

        public C7132b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Bitmap bitmap, String str) {
            Intrinsics3.checkNotNullParameter(bitmap, "<anonymous parameter 0>");
            return Unit.f27425a;
        }
    }

    /* compiled from: UserAvatarPresenceView.kt */
    /* renamed from: com.discord.views.user.UserAvatarPresenceView$c */
    public static final class C7133c extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ String $iconUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7133c(String str) {
            super(1);
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
            Intrinsics3.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
            imageRequestBuilder2.f19623l = new UserAvatarPresenceView2(this);
            return Unit.f27425a;
        }
    }

    /* compiled from: UserAvatarPresenceView.kt */
    /* renamed from: com.discord.views.user.UserAvatarPresenceView$d */
    public static final class C7134d extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ String $iconUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7134d(String str) {
            super(1);
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
            Intrinsics3.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
            imageRequestBuilder2.f19623l = new UserAvatarPresenceView3(this);
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.user_avatar_presence_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.avatar_container;
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C5419R.id.avatar_container);
            if (frameLayout != null) {
                i = C5419R.id.avatar_cutout;
                ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.avatar_cutout);
                if (imageView != null) {
                    i = C5419R.id.static_avatar;
                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.static_avatar);
                    if (simpleDraweeView2 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                        i = C5419R.id.user_avatar_presence_status;
                        StatusView statusView = (StatusView) viewInflate.findViewById(C5419R.id.user_avatar_presence_status);
                        if (statusView != null) {
                            UserAvatarPresenceViewBinding userAvatarPresenceViewBinding = new UserAvatarPresenceViewBinding(relativeLayout, simpleDraweeView, frameLayout, imageView, simpleDraweeView2, relativeLayout, statusView);
                            Intrinsics3.checkNotNullExpressionValue(userAvatarPresenceViewBinding, "UserAvatarPresenceViewBi…rom(context), this, true)");
                            this.binding = userAvatarPresenceViewBinding;
                            this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
                            this.onAvatarBitmapLoadedListener = C7132b.f19360j;
                            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.UserAvatarPresenceView);
                            Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.UserAvatarPresenceView)");
                            int color = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, C5419R.attr.primary_700));
                            this.cutoutSpacePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
                            typedArrayObtainStyledAttributes.recycle();
                            setAvatarBackgroundColor(color);
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
                            simpleDraweeView.setClipToOutline(true);
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8622a(C7131a viewState) {
        boolean zIsDataUrlForGif;
        String forUser$default;
        String forGuildMember$default;
        boolean z2;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        GuildMember guildMember = viewState.f19359e;
        User user = viewState.f19355a;
        boolean z3 = !AccessibilityUtils.INSTANCE.isReducedMotionEnabled();
        if (guildMember == null || !guildMember.hasAvatar()) {
            String avatar = user.getAvatar();
            if (avatar == null || !StringsJVM.startsWith$default(avatar, "data:", false, 2, null)) {
                String avatar2 = user.getAvatar();
                if (avatar2 != null) {
                    zIsDataUrlForGif = z3 && IconUtils.INSTANCE.isImageHashAnimated(avatar2);
                } else {
                    zIsDataUrlForGif = false;
                }
                forUser$default = IconUtils.getForUser$default(viewState.f19355a, z3, null, 4, null);
            } else {
                forUser$default = user.getAvatar();
                zIsDataUrlForGif = forUser$default != null && IconUtils.INSTANCE.isDataUrlForGif(forUser$default);
            }
        } else {
            forUser$default = guildMember.getAvatarHash();
            if (forUser$default == null || !StringsJVM.startsWith$default(forUser$default, "data:", false, 2, null)) {
                if (forUser$default != null) {
                    z2 = z3 && IconUtils.INSTANCE.isImageHashAnimated(forUser$default);
                } else {
                    z2 = false;
                }
                forGuildMember$default = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, z3, 2, null);
                zIsDataUrlForGif = z2;
                SimpleDraweeView simpleDraweeView = this.binding.f1310b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
                IconUtils.setIcon$default(simpleDraweeView, forGuildMember$default, 0, new C7133c(forGuildMember$default), this.imagesChangeDetector, 4, (Object) null);
                if (zIsDataUrlForGif) {
                    String forUser$default2 = (guildMember == null || !guildMember.hasAvatar()) ? IconUtils.getForUser$default(viewState.f19355a, false, null, 4, null) : IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, false, 2, null);
                    SimpleDraweeView simpleDraweeView2 = this.binding.f1312d;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.staticAvatar");
                    IconUtils.setIcon$default(simpleDraweeView2, forUser$default2, 0, new C7134d(forUser$default2), this.imagesChangeDetector, 4, (Object) null);
                }
                StatusView statusView = this.binding.f1313e;
                Intrinsics3.checkNotNullExpressionValue(statusView, "binding.userAvatarPresenceStatus");
                statusView.setVisibility(!viewState.f19358d && UserUtils.INSTANCE.isStatusVisible(viewState.f19355a, viewState.f19356b, true) ? 0 : 8);
                this.binding.f1313e.setPresence(viewState.f19356b);
            }
            zIsDataUrlForGif = IconUtils.INSTANCE.isDataUrlForGif(forUser$default);
        }
        forGuildMember$default = forUser$default;
        SimpleDraweeView simpleDraweeView3 = this.binding.f1310b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.avatar");
        IconUtils.setIcon$default(simpleDraweeView3, forGuildMember$default, 0, new C7133c(forGuildMember$default), this.imagesChangeDetector, 4, (Object) null);
        if (zIsDataUrlForGif) {
        }
        StatusView statusView2 = this.binding.f1313e;
        Intrinsics3.checkNotNullExpressionValue(statusView2, "binding.userAvatarPresenceStatus");
        statusView2.setVisibility(!viewState.f19358d && UserUtils.INSTANCE.isStatusVisible(viewState.f19355a, viewState.f19356b, true) ? 0 : 8);
        this.binding.f1313e.setPresence(viewState.f19356b);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        ImageView imageView = this.binding.f1311c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.avatarCutout");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = size;
        layoutParams.height = size;
        imageView.setLayoutParams(layoutParams);
        int i = size - (this.cutoutSpacePx * 2);
        SimpleDraweeView simpleDraweeView = this.binding.f1310b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
        ViewGroup.LayoutParams layoutParams2 = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams2.width = i;
        layoutParams2.height = i;
        simpleDraweeView.setLayoutParams(layoutParams2);
        float f = size;
        float f2 = 0.3375f * f;
        float f3 = 0.0375f * f;
        float f4 = f * 0.05f;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        float f5 = resources.getDisplayMetrics().density;
        float f6 = 12 * f5;
        if (f2 < f6) {
            float f7 = f6 / f2;
            f2 *= f7;
            f3 *= f7;
            f4 *= f7;
        }
        float f8 = f3;
        float fMax = Math.max(f3, f5 * 2);
        StatusView statusView = this.binding.f1313e;
        Intrinsics3.checkNotNullExpressionValue(statusView, "binding.userAvatarPresenceStatus");
        ViewGroup.LayoutParams layoutParams3 = statusView.getLayoutParams();
        layoutParams3.width = (int) f2;
        StatusView statusView2 = this.binding.f1313e;
        Intrinsics3.checkNotNullExpressionValue(statusView2, "binding.userAvatarPresenceStatus");
        statusView2.setLayoutParams(layoutParams3);
        StatusView statusView3 = this.binding.f1313e;
        Intrinsics3.checkNotNullExpressionValue(statusView3, "binding.userAvatarPresenceStatus");
        statusView3.setTranslationX(f8 - this.cutoutSpacePx);
        StatusView statusView4 = this.binding.f1313e;
        Intrinsics3.checkNotNullExpressionValue(statusView4, "binding.userAvatarPresenceStatus");
        statusView4.setTranslationY(f8 - this.cutoutSpacePx);
        this.binding.f1313e.setBorderWidth((int) fMax);
        this.binding.f1313e.setCornerRadius(f4);
    }

    public final void setAvatarBackgroundColor(@ColorInt int backgroundColor) {
        this.binding.f1313e.setBackgroundColor(backgroundColor);
        ImageView imageView = this.binding.f1311c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.avatarCutout");
        ColorCompat2.tintWithColor(imageView, backgroundColor);
    }

    public final void setOnAvatarBitmapLoadedListener(Function2<? super Bitmap, ? super String, Unit> onAvatarBitmapLoadedListener) {
        Intrinsics3.checkNotNullParameter(onAvatarBitmapLoadedListener, "onAvatarBitmapLoadedListener");
        this.onAvatarBitmapLoadedListener = onAvatarBitmapLoadedListener;
    }

    /* compiled from: UserAvatarPresenceView.kt */
    /* renamed from: com.discord.views.user.UserAvatarPresenceView$a */
    public static final class C7131a {

        /* renamed from: a */
        public final User f19355a;

        /* renamed from: b */
        public final Presence f19356b;

        /* renamed from: c */
        public final StreamContext f19357c;

        /* renamed from: d */
        public final boolean f19358d;

        /* renamed from: e */
        public final GuildMember f19359e;

        public C7131a(User user, Presence presence, StreamContext streamContext, boolean z2, GuildMember guildMember, int i) {
            int i2 = i & 16;
            Intrinsics3.checkNotNullParameter(user, "user");
            this.f19355a = user;
            this.f19356b = presence;
            this.f19357c = streamContext;
            this.f19358d = z2;
            this.f19359e = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C7131a)) {
                return false;
            }
            C7131a c7131a = (C7131a) obj;
            return Intrinsics3.areEqual(this.f19355a, c7131a.f19355a) && Intrinsics3.areEqual(this.f19356b, c7131a.f19356b) && Intrinsics3.areEqual(this.f19357c, c7131a.f19357c) && this.f19358d == c7131a.f19358d && Intrinsics3.areEqual(this.f19359e, c7131a.f19359e);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.f19355a;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            Presence presence = this.f19356b;
            int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
            StreamContext streamContext = this.f19357c;
            int iHashCode3 = (iHashCode2 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            boolean z2 = this.f19358d;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            GuildMember guildMember = this.f19359e;
            return i2 + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ViewState(user=");
            sbM833U.append(this.f19355a);
            sbM833U.append(", presence=");
            sbM833U.append(this.f19356b);
            sbM833U.append(", streamContext=");
            sbM833U.append(this.f19357c);
            sbM833U.append(", showPresence=");
            sbM833U.append(this.f19358d);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.f19359e);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public C7131a(User user, Presence presence, StreamContext streamContext, boolean z2, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.f19355a = user;
            this.f19356b = presence;
            this.f19357c = streamContext;
            this.f19358d = z2;
            this.f19359e = guildMember;
        }
    }
}
