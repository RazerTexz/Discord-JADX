package com.discord.widgets.user.profile;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.user.UserProfile;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.databinding.UserProfileHeaderBadgeBinding;
import com.discord.databinding.UserProfileHeaderViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.viewcontroller.ViewDetachedFromWindowObservable;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.UsernameView;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.widgets.channels.UserAkaView;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.UserNameFormatter;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p161j.p182q.BasePostprocessor;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.Subscription;

/* compiled from: UserProfileHeaderView.kt */
/* loaded from: classes.dex */
public final class UserProfileHeaderView extends ConstraintLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SimpleRecyclerAdapter<Badge, BadgeViewHolder> badgesAdapter;
    private MGImages.DistinctChangeDetector bannerChangeDetector;
    private final UserProfileHeaderViewBinding binding;
    private Function0<Unit> onAvatarEdit;
    private Function1<? super Integer, Unit> onAvatarRepresentativeColorUpdated;
    private Function1<? super Badge, Unit> onBadgeClick;
    private Function0<Unit> onBannerPress;
    private Subscription setBannerBackgroundColorSubscription;
    private Subscription syncAvatarRepresentativeColorSubscription;
    private int userProfileHeaderBackgroundColor;

    /* compiled from: UserProfileHeaderView.kt */
    public final class BadgeViewHolder extends SimpleRecyclerAdapter.ViewHolder<Badge> {
        private final UserProfileHeaderBadgeBinding binding;
        public final /* synthetic */ UserProfileHeaderView this$0;

        /* JADX WARN: Illegal instructions before constructor call */
        public BadgeViewHolder(UserProfileHeaderView userProfileHeaderView, UserProfileHeaderBadgeBinding userProfileHeaderBadgeBinding) {
            Intrinsics3.checkNotNullParameter(userProfileHeaderBadgeBinding, "binding");
            this.this$0 = userProfileHeaderView;
            ImageView imageView = userProfileHeaderBadgeBinding.f15339a;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.root");
            super(imageView);
            this.binding = userProfileHeaderBadgeBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(Badge badge) {
            bind2(badge);
        }

        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(Badge data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.binding.f15340b.setImageResource(data.getIcon());
            ImageView imageView = this.binding.f15340b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.userSheetBadgeImage");
            CharSequence text = data.getText();
            if (text == null) {
                text = data.getTooltip();
            }
            imageView.setContentDescription(text);
            this.binding.f15340b.setOnClickListener(new UserProfileHeaderView2(this, data));
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void bind(UserProfileHeaderView userProfileHeaderView, AppComponent appComponent, Observable<UserProfileHeaderViewModel.ViewState> observable) {
            Intrinsics3.checkNotNullParameter(userProfileHeaderView, "$this$bind");
            Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
            Intrinsics3.checkNotNullParameter(observable, "observable");
            Observable<R> observableM11083G = observable.m11118y(UserProfileHeaderView$Companion$bind$$inlined$filterIs$1.INSTANCE).m11083G(UserProfileHeaderView$Companion$bind$$inlined$filterIs$2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11083G, appComponent, null, 2, null), appComponent.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new UserProfileHeaderView3(userProfileHeaderView), 62, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$1 */
    public static final class C102971 extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ Ref$BooleanRef $bannerColorUpdatedFromViewState;
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        /* compiled from: UserProfileHeaderView.kt */
        /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends BasePostprocessor {
            public AnonymousClass1() {
            }

            @Override // p007b.p109f.p161j.p182q.BasePostprocessor
            public void process(Bitmap bitmap) {
                if (bitmap != null) {
                    C102971 c102971 = C102971.this;
                    if (c102971.$bannerColorUpdatedFromViewState.element) {
                        return;
                    }
                    UserProfileHeaderView.this.updateBannerColor(c102971.$viewState);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C102971(Ref$BooleanRef ref$BooleanRef, UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            super(1);
            this.$bannerColorUpdatedFromViewState = ref$BooleanRef;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            Intrinsics3.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            imageRequestBuilder.f19623l = new AnonymousClass1();
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$2 */
    public static final class ViewOnClickListenerC102982 implements View.OnClickListener {
        public ViewOnClickListenerC102982() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$onTapBanner(UserProfileHeaderView.this);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$3 */
    public static final class ViewOnClickListenerC102993 implements View.OnClickListener {
        public ViewOnClickListenerC102993() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$onTapBanner(UserProfileHeaderView.this);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$getCustomStatusDraweeSpanStringBuilder$1 */
    public static final class C103001 implements EmojiNode.RenderContext {
        public final /* synthetic */ boolean $shouldAnimate;
        private final Context context;
        private final boolean isAnimationEnabled;

        public C103001(boolean z2) {
            this.$shouldAnimate = z2;
            this.context = UserProfileHeaderView.this.getContext();
            this.isAnimationEnabled = z2;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        public Context getContext() {
            return this.context;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        /* renamed from: isAnimationEnabled, reason: from getter */
        public boolean getIsAnimationEnabled() {
            return this.isAnimationEnabled;
        }

        @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
        public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$notifyAvatarColorListenerAsync$1 */
    public static final class C103011 extends Lambda implements Function1<Subscription, Unit> {
        public C103011() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            UserProfileHeaderView.access$setSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView.this, subscription);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$notifyAvatarColorListenerAsync$2 */
    public static final class C103022 extends Lambda implements Function1<Integer, Unit> {
        public C103022() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (num != null) {
                UserProfileHeaderView.this.getOnAvatarRepresentativeColorUpdated().invoke(num);
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$observeRepresentativeColor$1 */
    public static final class C103031<T, R> implements Func1<Integer, Boolean> {
        public static final C103031 INSTANCE = new C103031();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Integer num) {
            return Boolean.valueOf(num != null);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateBannerBackgroundColorAsync$1 */
    public static final class C103041 extends Lambda implements Function1<Subscription, Unit> {
        public C103041() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            UserProfileHeaderView.access$setSetBannerBackgroundColorSubscription$p(UserProfileHeaderView.this, subscription);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateBannerBackgroundColorAsync$2 */
    public static final class C103052 extends Lambda implements Function1<Integer, Unit> {
        public C103052() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (num != null) {
                UserProfileHeaderView.access$getBinding$p(UserProfileHeaderView.this).f15343c.setBackgroundColor(num.intValue());
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$1 */
    public static final class C103061 extends Lambda implements Function2<Bitmap, String, Unit> {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103061(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            super(2);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, String str) {
            invoke2(bitmap, str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Bitmap bitmap, String str) {
            Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
            GuildMember guildMember = this.$viewState.getGuildMember();
            if (guildMember == null || !guildMember.hasAvatar()) {
                RepresentativeColors2.getUserRepresentativeColors().handleBitmap(this.$viewState.getAvatarColorId(), bitmap, str);
            } else {
                RepresentativeColors2.getGuildMemberRepresentativeColors().handleBitmap(this.$viewState.getGuildMemberColorId(), bitmap, str);
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$2 */
    public static final class ViewOnClickListenerC103072 implements View.OnClickListener {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC103072(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$editAvatar(UserProfileHeaderView.this, this.$viewState);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$3 */
    public static final class ViewOnClickListenerC103083 implements View.OnClickListener {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC103083(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$editAvatar(UserProfileHeaderView.this, this.$viewState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.user_profile_header_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.avatar_edit;
        CardView cardView = (CardView) viewInflate.findViewById(C5419R.id.avatar_edit);
        if (cardView != null) {
            i = C5419R.id.banner;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.banner);
            if (simpleDraweeView != null) {
                i = C5419R.id.banner_edit;
                CardView cardView2 = (CardView) viewInflate.findViewById(C5419R.id.banner_edit);
                if (cardView2 != null) {
                    i = C5419R.id.gif_tag;
                    ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.gif_tag);
                    if (imageView != null) {
                        i = C5419R.id.large_avatar;
                        UserAvatarPresenceView userAvatarPresenceView = (UserAvatarPresenceView) viewInflate.findViewById(C5419R.id.large_avatar);
                        if (userAvatarPresenceView != null) {
                            i = C5419R.id.large_avatar_barrier;
                            Barrier barrier = (Barrier) viewInflate.findViewById(C5419R.id.large_avatar_barrier);
                            if (barrier != null) {
                                i = C5419R.id.user_aka;
                                UserAkaView userAkaView = (UserAkaView) viewInflate.findViewById(C5419R.id.user_aka);
                                if (userAkaView != null) {
                                    i = C5419R.id.user_profile_header_badges_recycler;
                                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C5419R.id.user_profile_header_badges_recycler);
                                    if (recyclerView != null) {
                                        i = C5419R.id.user_profile_header_custom_status;
                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) viewInflate.findViewById(C5419R.id.user_profile_header_custom_status);
                                        if (simpleDraweeSpanTextView != null) {
                                            i = C5419R.id.user_profile_header_name_wrap;
                                            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.user_profile_header_name_wrap);
                                            if (linearLayout != null) {
                                                i = C5419R.id.user_profile_header_primary_name;
                                                UsernameView usernameView = (UsernameView) viewInflate.findViewById(C5419R.id.user_profile_header_primary_name);
                                                if (usernameView != null) {
                                                    i = C5419R.id.user_profile_header_secondary_name;
                                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = (SimpleDraweeSpanTextView) viewInflate.findViewById(C5419R.id.user_profile_header_secondary_name);
                                                    if (simpleDraweeSpanTextView2 != null) {
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                                        UserProfileHeaderViewBinding userProfileHeaderViewBinding = new UserProfileHeaderViewBinding(constraintLayout, cardView, simpleDraweeView, cardView2, imageView, userAvatarPresenceView, barrier, userAkaView, recyclerView, simpleDraweeSpanTextView, linearLayout, usernameView, simpleDraweeSpanTextView2, constraintLayout);
                                                        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderViewBinding, "UserProfileHeaderViewBin…rom(context), this, true)");
                                                        this.binding = userProfileHeaderViewBinding;
                                                        this.bannerChangeDetector = new MGImages.DistinctChangeDetector();
                                                        this.onBadgeClick = UserProfileHeaderView6.INSTANCE;
                                                        this.onAvatarEdit = UserProfileHeaderView4.INSTANCE;
                                                        this.onBannerPress = UserProfileHeaderView7.INSTANCE;
                                                        this.onAvatarRepresentativeColorUpdated = UserProfileHeaderView5.INSTANCE;
                                                        RightToLeftGridLayoutManager rightToLeftGridLayoutManager = new RightToLeftGridLayoutManager(context, 3, 1, true);
                                                        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userProfileHeaderBadgesRecycler");
                                                        recyclerView.setLayoutManager(rightToLeftGridLayoutManager);
                                                        SimpleRecyclerAdapter<Badge, BadgeViewHolder> simpleRecyclerAdapter = new SimpleRecyclerAdapter<>(null, new C102961(), 1, null);
                                                        this.badgesAdapter = simpleRecyclerAdapter;
                                                        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userProfileHeaderBadgesRecycler");
                                                        recyclerView.setAdapter(simpleRecyclerAdapter);
                                                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.UserProfileHeaderView);
                                                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.UserProfileHeaderView)");
                                                        this.userProfileHeaderBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, C5419R.attr.primary_700));
                                                        typedArrayObtainStyledAttributes.recycle();
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$editAvatar(UserProfileHeaderView userProfileHeaderView, UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        userProfileHeaderView.editAvatar(loaded);
    }

    public static final /* synthetic */ UserProfileHeaderViewBinding access$getBinding$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.binding;
    }

    public static final /* synthetic */ Subscription access$getSetBannerBackgroundColorSubscription$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.setBannerBackgroundColorSubscription;
    }

    public static final /* synthetic */ Subscription access$getSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView userProfileHeaderView) {
        return userProfileHeaderView.syncAvatarRepresentativeColorSubscription;
    }

    public static final /* synthetic */ void access$onTapBanner(UserProfileHeaderView userProfileHeaderView) {
        userProfileHeaderView.onTapBanner();
    }

    public static final /* synthetic */ void access$setSetBannerBackgroundColorSubscription$p(UserProfileHeaderView userProfileHeaderView, Subscription subscription) {
        userProfileHeaderView.setBannerBackgroundColorSubscription = subscription;
    }

    public static final /* synthetic */ void access$setSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView userProfileHeaderView, Subscription subscription) {
        userProfileHeaderView.syncAvatarRepresentativeColorSubscription = subscription;
    }

    private final void configureAka(UserProfileHeaderViewModel.ViewState.Loaded viewState) throws Resources.NotFoundException {
        UserAkaView userAkaView = this.binding.f15347g;
        Intrinsics3.checkNotNullExpressionValue(userAkaView, "binding.userAka");
        userAkaView.setVisibility(viewState.getShowAkas() ? 0 : 8);
        this.binding.f15347g.configure(viewState.getGuildMembersForAka());
    }

    private final void configureBanner(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        String banner;
        String forUserBanner;
        String str;
        GuildMember guildMember = viewState.getGuildMember();
        if (guildMember == null || (banner = guildMember.getBannerHash()) == null) {
            banner = viewState.getBanner();
        }
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        int iMax = Math.max(i, resources2.getDisplayMetrics().heightPixels);
        if (banner == null || !StringsJVM.startsWith$default(banner, "data:", false, 2, null)) {
            GuildMember guildMember2 = viewState.getGuildMember();
            if (guildMember2 == null || !guildMember2.hasBanner()) {
                forUserBanner = IconUtils.INSTANCE.getForUserBanner(viewState.getUser().getId(), banner, Integer.valueOf(iMax), viewState.getShouldAnimateBanner());
            } else {
                IconUtils iconUtils = IconUtils.INSTANCE;
                GuildMember guildMember3 = viewState.getGuildMember();
                forUserBanner = iconUtils.getForGuildMemberBanner(banner, (guildMember3 != null ? Long.valueOf(guildMember3.getGuildId()) : null).longValue(), viewState.getUser().getId(), Integer.valueOf(iMax), viewState.getShouldAnimateBanner());
            }
            str = forUserBanner;
        } else {
            str = banner;
        }
        boolean z2 = !(str == null || StringsJVM.isBlank(str));
        boolean z3 = (banner != null && IconUtils.INSTANCE.isDataUrlForGif(banner)) || (banner != null && !StringsJVM.startsWith$default(banner, "data:", false, 2, null) && IconUtils.INSTANCE.isImageHashAnimated(banner));
        SimpleDraweeView simpleDraweeView = this.binding.f15343c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.banner");
        simpleDraweeView.setAspectRatio(!z2 ? 5.0f : 2.5f);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        notifyAvatarColorListenerAsync(viewState);
        if ((!z2 || z3) && viewState.getIsProfileLoaded()) {
            updateBannerColor(viewState);
            ref$BooleanRef.element = true;
        } else if (!viewState.getIsProfileLoaded()) {
            this.binding.f15343c.setBackgroundColor(this.userProfileHeaderBackgroundColor);
        }
        SimpleDraweeView simpleDraweeView2 = this.binding.f15343c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.banner");
        MGImages.setImage$default(simpleDraweeView2, str, 0, 0, false, new C102971(ref$BooleanRef, viewState), this.bannerChangeDetector, 28, null);
        this.binding.f15343c.setOnClickListener(new ViewOnClickListenerC102982());
        this.binding.f15344d.setOnClickListener(new ViewOnClickListenerC102993());
        ImageView imageView = this.binding.f15345e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.gifTag");
        imageView.setVisibility(viewState.getShouldShowGIFTag() ? 0 : 8);
    }

    private final void configurePrimaryName(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        User user = viewState.getUser();
        GuildMember guildMember = viewState.getGuildMember();
        int dimension = (int) getResources().getDimension(C5419R.dimen.avatar_size_medium);
        this.binding.f15350j.m8568b(getPrimaryNameTextForUser(user, guildMember), viewState.getShowMediumAvatar() ? IconUtils.getForUser(viewState.getUser(), false, Integer.valueOf(dimension)) : null, false, Integer.valueOf(dimension), Integer.valueOf(this.userProfileHeaderBackgroundColor));
        this.binding.f15350j.m8567a(user.getIsBot(), user.getIsSystemUser() ? C5419R.string.system_dm_tag_system : C5419R.string.bot_tag, UserUtils.INSTANCE.isVerifiedBot(user));
    }

    private final void configureSecondaryName(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        User user = viewState.getUser();
        GuildMember guildMember = viewState.getGuildMember();
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        if (viewState.getShowSmallAvatar()) {
            int dimension = (int) getResources().getDimension(C5419R.dimen.avatar_size_profile_small);
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilderExtensions.setAvatar$default(draweeSpanStringBuilder, context, IconUtils.getForUser(viewState.getUser(), false, Integer.valueOf(dimension)), false, Integer.valueOf(dimension), Integer.valueOf(this.userProfileHeaderBackgroundColor), null, 32, null);
        }
        CharSequence secondaryNameTextForUser = getSecondaryNameTextForUser(user, guildMember);
        boolean z2 = ((secondaryNameTextForUser == null || StringsJVM.isBlank(secondaryNameTextForUser)) || viewState.getShowAkas()) ? false : true;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f15351k;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.userProfileHeaderSecondaryName");
        simpleDraweeSpanTextView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            draweeSpanStringBuilder.append(secondaryNameTextForUser);
            this.binding.f15351k.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        }
    }

    private final void editAvatar(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        if (viewState.getEditable()) {
            this.onAvatarEdit.invoke();
        }
    }

    private final DraweeSpanStringBuilder getCustomStatusDraweeSpanStringBuilder(Activity customStatusActivity, boolean shouldAnimate) {
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        ActivityEmoji emoji = customStatusActivity.getEmoji();
        EmojiNode emojiNodeFrom$default = null;
        if (emoji != null) {
            EmojiNode.Companion companion = EmojiNode.INSTANCE;
            emojiNodeFrom$default = EmojiNode.Companion.from$default(companion, 0, companion.generateEmojiIdAndType(emoji), 1, (Object) null);
        }
        if (emojiNodeFrom$default != null) {
            emojiNodeFrom$default.render((SpannableStringBuilder) draweeSpanStringBuilder, new C103001(shouldAnimate));
        }
        String state = customStatusActivity.getState();
        if (state != null) {
            if (emojiNodeFrom$default != null) {
                draweeSpanStringBuilder.append((char) 8194);
            }
            draweeSpanStringBuilder.append((CharSequence) state);
        }
        return draweeSpanStringBuilder;
    }

    private final SpannableStringBuilder getPrimaryNameTextForUser(User user, GuildMember guildMember) {
        String nick = guildMember != null ? guildMember.getNick() : null;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        return UserNameFormatter.getSpannableForUserNameWithDiscrim(user, nick, context, C5419R.attr.colorHeaderPrimary, C5419R.attr.font_display_bold, C5419R.integer.uikit_textsize_xxlarge_sp, C5419R.attr.colorHeaderSecondary, C5419R.attr.font_primary_semibold, C5419R.integer.uikit_textsize_xxlarge_sp);
    }

    private final CharSequence getSecondaryNameTextForUser(User user, GuildMember guildMember) {
        if (guildMember == null || guildMember.getNick() == null) {
            return null;
        }
        return UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
    }

    private final void notifyAvatarColorListenerAsync(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Subscription subscription = this.syncAvatarRepresentativeColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(observeRepresentativeColor(viewState), UserProfileHeaderView.class, (Context) null, new C103011(), (Function1) null, (Function0) null, (Function0) null, new C103022(), 58, (Object) null);
    }

    private final Observable<Integer> observeRepresentativeColor(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        GuildMember guildMember = viewState.getGuildMember();
        Observable<Integer> observableM11103b0 = ObservableExtensionsKt.m8518ui((guildMember == null || !guildMember.hasAvatar()) ? RepresentativeColors2.getUserRepresentativeColors().observeRepresentativeColor(viewState.getAvatarColorId()) : RepresentativeColors2.getGuildMemberRepresentativeColors().observeRepresentativeColor(viewState.getGuildMemberColorId())).m11102a0(new ViewDetachedFromWindowObservable(this).observe()).m11103b0(C103031.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11103b0, "representativeColorObser….takeUntil { it != null }");
        return observableM11103b0;
    }

    private final void onTapBanner() {
        this.onBannerPress.invoke();
    }

    private final void updateBannerBackgroundColorAsync(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Subscription subscription = this.setBannerBackgroundColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(observeRepresentativeColor(viewState), UserProfileHeaderView.class, (Context) null, new C103041(), (Function1) null, (Function0) null, (Function0) null, new C103052(), 58, (Object) null);
    }

    public final Function0<Unit> getOnAvatarEdit() {
        return this.onAvatarEdit;
    }

    public final Function1<Integer, Unit> getOnAvatarRepresentativeColorUpdated() {
        return this.onAvatarRepresentativeColorUpdated;
    }

    public final Function1<Badge, Unit> getOnBadgeClick() {
        return this.onBadgeClick;
    }

    public final Function0<Unit> getOnBannerPress() {
        return this.onBannerPress;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.userProfileHeaderBackgroundColor;
        if (i != 0) {
            setBackgroundColor(i);
            this.binding.f15346f.setAvatarBackgroundColor(this.userProfileHeaderBackgroundColor);
            this.binding.f15343c.setBackgroundColor(this.userProfileHeaderBackgroundColor);
        }
    }

    public final void setOnAvatarEdit(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onAvatarEdit = function0;
    }

    public final void setOnAvatarRepresentativeColorUpdated(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onAvatarRepresentativeColorUpdated = function1;
    }

    public final void setOnBadgeClick(Function1<? super Badge, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onBadgeClick = function1;
    }

    public final void setOnBannerPress(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onBannerPress = function0;
    }

    public final void updateBannerColor(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Integer numValueOf;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        String bannerColorHex = viewState.getBannerColorHex();
        if (bannerColorHex != null) {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(bannerColorHex));
            } catch (IllegalArgumentException e) {
                Logger.e$default(AppLog.f14950g, outline.m883w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            this.binding.f15343c.setBackgroundColor(numValueOf.intValue());
        }
        if (numValueOf == null) {
            updateBannerBackgroundColorAsync(viewState);
        }
    }

    public final void updateViewState(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        this.binding.f15346f.setOnAvatarBitmapLoadedListener(new C103061(viewState));
        this.binding.f15346f.setOnClickListener(new ViewOnClickListenerC103072(viewState));
        this.binding.f15342b.setOnClickListener(new ViewOnClickListenerC103083(viewState));
        configureBanner(viewState);
        this.binding.f15346f.m8622a(new UserAvatarPresenceView.C7131a(viewState.getUser(), viewState.getPresence(), viewState.getStreamContext(), viewState.getShowPresence(), viewState.getGuildMember()));
        configurePrimaryName(viewState);
        configureAka(viewState);
        configureSecondaryName(viewState);
        Badge.Companion companion = Badge.INSTANCE;
        User user = viewState.getUser();
        UserProfile userProfile = viewState.getUserProfile();
        boolean zIsMeUserPremium = viewState.isMeUserPremium();
        boolean zIsMeUserVerified = viewState.isMeUserVerified();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        this.badgesAdapter.setData(companion.getBadgesForUser(user, userProfile, zIsMeUserPremium, zIsMeUserVerified, context));
        Presence presence = viewState.getPresence();
        Activity customStatusActivity = presence != null ? PresenceUtils.INSTANCE.getCustomStatusActivity(presence) : null;
        if (customStatusActivity != null) {
            this.binding.f15349i.setDraweeSpanStringBuilder(getCustomStatusDraweeSpanStringBuilder(customStatusActivity, viewState.getAllowAnimatedEmojis()));
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f15349i;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.userProfileHeaderCustomStatus");
        simpleDraweeSpanTextView.setVisibility(customStatusActivity != null ? 0 : 8);
        CardView cardView = this.binding.f15342b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.avatarEdit");
        cardView.setVisibility(viewState.getEditable() ? 0 : 8);
        CardView cardView2 = this.binding.f15344d;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.bannerEdit");
        cardView2.setVisibility(viewState.getEditable() ? 0 : 8);
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$1 */
    public static final class C102961 extends Lambda implements Function2<LayoutInflater, ViewGroup, BadgeViewHolder> {
        public C102961() {
            super(2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final BadgeViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics3.checkNotNullParameter(layoutInflater, "inflater");
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            View viewInflate = layoutInflater.inflate(C5419R.layout.user_profile_header_badge, viewGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            ImageView imageView = (ImageView) viewInflate;
            UserProfileHeaderBadgeBinding userProfileHeaderBadgeBinding = new UserProfileHeaderBadgeBinding(imageView, imageView);
            Intrinsics3.checkNotNullExpressionValue(userProfileHeaderBadgeBinding, "UserProfileHeaderBadgeBi…(inflater, parent, false)");
            return new BadgeViewHolder(UserProfileHeaderView.this, userProfileHeaderBadgeBinding);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ BadgeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return invoke2(layoutInflater, viewGroup);
        }
    }
}
