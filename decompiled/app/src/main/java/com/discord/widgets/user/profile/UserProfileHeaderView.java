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
import b.f.j.q.a;
import com.discord.R;
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
import com.discord.utilities.colors.RepresentativeColorsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.viewcontroller.ViewDetachedFromWindowObservable;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.UsernameView;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.widgets.channels.UserAkaView;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.UserNameFormatterKt;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.g0.t;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import rx.Observable;
import rx.Subscription;

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
            m.checkNotNullParameter(userProfileHeaderBadgeBinding, "binding");
            this.this$0 = userProfileHeaderView;
            ImageView imageView = userProfileHeaderBadgeBinding.a;
            m.checkNotNullExpressionValue(imageView, "binding.root");
            super(imageView);
            this.binding = userProfileHeaderBadgeBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(Badge badge) {
            bind2(badge);
        }

        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(Badge data) {
            m.checkNotNullParameter(data, "data");
            this.binding.f2165b.setImageResource(data.getIcon());
            ImageView imageView = this.binding.f2165b;
            m.checkNotNullExpressionValue(imageView, "binding.userSheetBadgeImage");
            CharSequence text = data.getText();
            if (text == null) {
                text = data.getTooltip();
            }
            imageView.setContentDescription(text);
            this.binding.f2165b.setOnClickListener(new UserProfileHeaderView$BadgeViewHolder$bind$1(this, data));
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void bind(UserProfileHeaderView userProfileHeaderView, AppComponent appComponent, Observable<UserProfileHeaderViewModel.ViewState> observable) {
            m.checkNotNullParameter(userProfileHeaderView, "$this$bind");
            m.checkNotNullParameter(appComponent, "appComponent");
            m.checkNotNullParameter(observable, "observable");
            Observable<R> observableG = observable.y(UserProfileHeaderView$Companion$bind$$inlined$filterIs$1.INSTANCE).G(UserProfileHeaderView$Companion$bind$$inlined$filterIs$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, appComponent, null, 2, null), appComponent.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new UserProfileHeaderView$Companion$bind$1(userProfileHeaderView), 62, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ Ref$BooleanRef $bannerColorUpdatedFromViewState;
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        /* compiled from: UserProfileHeaderView.kt */
        /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04721 extends a {
            public C04721() {
            }

            @Override // b.f.j.q.a
            public void process(Bitmap bitmap) {
                if (bitmap != null) {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (anonymousClass1.$bannerColorUpdatedFromViewState.element) {
                        return;
                    }
                    UserProfileHeaderView.this.updateBannerColor(anonymousClass1.$viewState);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$BooleanRef ref$BooleanRef, UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            super(1);
            this.$bannerColorUpdatedFromViewState = ref$BooleanRef;
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            m.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
            imageRequestBuilder.l = new C04721();
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$onTapBanner(UserProfileHeaderView.this);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$configureBanner$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$onTapBanner(UserProfileHeaderView.this);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$getCustomStatusDraweeSpanStringBuilder$1, reason: invalid class name */
    public static final class AnonymousClass1 implements EmojiNode.RenderContext {
        public final /* synthetic */ boolean $shouldAnimate;
        private final Context context;
        private final boolean isAnimationEnabled;

        public AnonymousClass1(boolean z2) {
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
            m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$notifyAvatarColorListenerAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            UserProfileHeaderView.access$setSyncAvatarRepresentativeColorSubscription$p(UserProfileHeaderView.this, subscription);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$notifyAvatarColorListenerAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (num != null) {
                UserProfileHeaderView.this.getOnAvatarRepresentativeColorUpdated().invoke(num);
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$observeRepresentativeColor$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Integer, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Integer num) {
            return Boolean.valueOf(num != null);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateBannerBackgroundColorAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            UserProfileHeaderView.access$setSetBannerBackgroundColorSubscription$p(UserProfileHeaderView.this, subscription);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateBannerBackgroundColorAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke2(num);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer num) {
            if (num != null) {
                UserProfileHeaderView.access$getBinding$p(UserProfileHeaderView.this).c.setBackgroundColor(num.intValue());
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<Bitmap, String, Unit> {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            super(2);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, String str) {
            invoke2(bitmap, str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Bitmap bitmap, String str) {
            m.checkNotNullParameter(bitmap, "bitmap");
            GuildMember guildMember = this.$viewState.getGuildMember();
            if (guildMember == null || !guildMember.hasAvatar()) {
                RepresentativeColorsKt.getUserRepresentativeColors().handleBitmap(this.$viewState.getAvatarColorId(), bitmap, str);
            } else {
                RepresentativeColorsKt.getGuildMemberRepresentativeColors().handleBitmap(this.$viewState.getGuildMemberColorId(), bitmap, str);
            }
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        public AnonymousClass2(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserProfileHeaderView.access$editAvatar(UserProfileHeaderView.this, this.$viewState);
        }
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$updateViewState$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded $viewState;

        public AnonymousClass3(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
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
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_profile_header_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.avatar_edit;
        CardView cardView = (CardView) viewInflate.findViewById(R.id.avatar_edit);
        if (cardView != null) {
            i = R.id.banner;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.banner);
            if (simpleDraweeView != null) {
                i = R.id.banner_edit;
                CardView cardView2 = (CardView) viewInflate.findViewById(R.id.banner_edit);
                if (cardView2 != null) {
                    i = R.id.gif_tag;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.gif_tag);
                    if (imageView != null) {
                        i = R.id.large_avatar;
                        UserAvatarPresenceView userAvatarPresenceView = (UserAvatarPresenceView) viewInflate.findViewById(R.id.large_avatar);
                        if (userAvatarPresenceView != null) {
                            i = R.id.large_avatar_barrier;
                            Barrier barrier = (Barrier) viewInflate.findViewById(R.id.large_avatar_barrier);
                            if (barrier != null) {
                                i = R.id.user_aka;
                                UserAkaView userAkaView = (UserAkaView) viewInflate.findViewById(R.id.user_aka);
                                if (userAkaView != null) {
                                    i = R.id.user_profile_header_badges_recycler;
                                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.user_profile_header_badges_recycler);
                                    if (recyclerView != null) {
                                        i = R.id.user_profile_header_custom_status;
                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) viewInflate.findViewById(R.id.user_profile_header_custom_status);
                                        if (simpleDraweeSpanTextView != null) {
                                            i = R.id.user_profile_header_name_wrap;
                                            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.user_profile_header_name_wrap);
                                            if (linearLayout != null) {
                                                i = R.id.user_profile_header_primary_name;
                                                UsernameView usernameView = (UsernameView) viewInflate.findViewById(R.id.user_profile_header_primary_name);
                                                if (usernameView != null) {
                                                    i = R.id.user_profile_header_secondary_name;
                                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = (SimpleDraweeSpanTextView) viewInflate.findViewById(R.id.user_profile_header_secondary_name);
                                                    if (simpleDraweeSpanTextView2 != null) {
                                                        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                                        UserProfileHeaderViewBinding userProfileHeaderViewBinding = new UserProfileHeaderViewBinding(constraintLayout, cardView, simpleDraweeView, cardView2, imageView, userAvatarPresenceView, barrier, userAkaView, recyclerView, simpleDraweeSpanTextView, linearLayout, usernameView, simpleDraweeSpanTextView2, constraintLayout);
                                                        m.checkNotNullExpressionValue(userProfileHeaderViewBinding, "UserProfileHeaderViewBin…rom(context), this, true)");
                                                        this.binding = userProfileHeaderViewBinding;
                                                        this.bannerChangeDetector = new MGImages.DistinctChangeDetector();
                                                        this.onBadgeClick = UserProfileHeaderView$onBadgeClick$1.INSTANCE;
                                                        this.onAvatarEdit = UserProfileHeaderView$onAvatarEdit$1.INSTANCE;
                                                        this.onBannerPress = UserProfileHeaderView$onBannerPress$1.INSTANCE;
                                                        this.onAvatarRepresentativeColorUpdated = UserProfileHeaderView$onAvatarRepresentativeColorUpdated$1.INSTANCE;
                                                        RightToLeftGridLayoutManager rightToLeftGridLayoutManager = new RightToLeftGridLayoutManager(context, 3, 1, true);
                                                        m.checkNotNullExpressionValue(recyclerView, "binding.userProfileHeaderBadgesRecycler");
                                                        recyclerView.setLayoutManager(rightToLeftGridLayoutManager);
                                                        SimpleRecyclerAdapter<Badge, BadgeViewHolder> simpleRecyclerAdapter = new SimpleRecyclerAdapter<>(null, new AnonymousClass1(), 1, null);
                                                        this.badgesAdapter = simpleRecyclerAdapter;
                                                        m.checkNotNullExpressionValue(recyclerView, "binding.userProfileHeaderBadgesRecycler");
                                                        recyclerView.setAdapter(simpleRecyclerAdapter);
                                                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.UserProfileHeaderView);
                                                        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.UserProfileHeaderView)");
                                                        this.userProfileHeaderBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, R.attr.primary_700));
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
        UserAkaView userAkaView = this.binding.g;
        m.checkNotNullExpressionValue(userAkaView, "binding.userAka");
        userAkaView.setVisibility(viewState.getShowAkas() ? 0 : 8);
        this.binding.g.configure(viewState.getGuildMembersForAka());
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
        m.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        int iMax = Math.max(i, resources2.getDisplayMetrics().heightPixels);
        if (banner == null || !t.startsWith$default(banner, "data:", false, 2, null)) {
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
        boolean z2 = !(str == null || t.isBlank(str));
        boolean z3 = (banner != null && IconUtils.INSTANCE.isDataUrlForGif(banner)) || (banner != null && !t.startsWith$default(banner, "data:", false, 2, null) && IconUtils.INSTANCE.isImageHashAnimated(banner));
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.banner");
        simpleDraweeView.setAspectRatio(!z2 ? 5.0f : 2.5f);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        notifyAvatarColorListenerAsync(viewState);
        if ((!z2 || z3) && viewState.getIsProfileLoaded()) {
            updateBannerColor(viewState);
            ref$BooleanRef.element = true;
        } else if (!viewState.getIsProfileLoaded()) {
            this.binding.c.setBackgroundColor(this.userProfileHeaderBackgroundColor);
        }
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.banner");
        MGImages.setImage$default(simpleDraweeView2, str, 0, 0, false, new AnonymousClass1(ref$BooleanRef, viewState), this.bannerChangeDetector, 28, null);
        this.binding.c.setOnClickListener(new AnonymousClass2());
        this.binding.d.setOnClickListener(new AnonymousClass3());
        ImageView imageView = this.binding.e;
        m.checkNotNullExpressionValue(imageView, "binding.gifTag");
        imageView.setVisibility(viewState.getShouldShowGIFTag() ? 0 : 8);
    }

    private final void configurePrimaryName(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        User user = viewState.getUser();
        GuildMember guildMember = viewState.getGuildMember();
        int dimension = (int) getResources().getDimension(R.dimen.avatar_size_medium);
        this.binding.j.b(getPrimaryNameTextForUser(user, guildMember), viewState.getShowMediumAvatar() ? IconUtils.getForUser(viewState.getUser(), false, Integer.valueOf(dimension)) : null, false, Integer.valueOf(dimension), Integer.valueOf(this.userProfileHeaderBackgroundColor));
        this.binding.j.a(user.getIsBot(), user.getIsSystemUser() ? R.string.system_dm_tag_system : R.string.bot_tag, UserUtils.INSTANCE.isVerifiedBot(user));
    }

    private final void configureSecondaryName(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        User user = viewState.getUser();
        GuildMember guildMember = viewState.getGuildMember();
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        if (viewState.getShowSmallAvatar()) {
            int dimension = (int) getResources().getDimension(R.dimen.avatar_size_profile_small);
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilderExtensionsKt.setAvatar$default(draweeSpanStringBuilder, context, IconUtils.getForUser(viewState.getUser(), false, Integer.valueOf(dimension)), false, Integer.valueOf(dimension), Integer.valueOf(this.userProfileHeaderBackgroundColor), null, 32, null);
        }
        CharSequence secondaryNameTextForUser = getSecondaryNameTextForUser(user, guildMember);
        boolean z2 = ((secondaryNameTextForUser == null || t.isBlank(secondaryNameTextForUser)) || viewState.getShowAkas()) ? false : true;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.k;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.userProfileHeaderSecondaryName");
        simpleDraweeSpanTextView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            draweeSpanStringBuilder.append(secondaryNameTextForUser);
            this.binding.k.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
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
            emojiNodeFrom$default.render((SpannableStringBuilder) draweeSpanStringBuilder, new AnonymousClass1(shouldAnimate));
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
        m.checkNotNullExpressionValue(context, "context");
        return UserNameFormatterKt.getSpannableForUserNameWithDiscrim(user, nick, context, R.attr.colorHeaderPrimary, R.attr.font_display_bold, R.integer.uikit_textsize_xxlarge_sp, R.attr.colorHeaderSecondary, R.attr.font_primary_semibold, R.integer.uikit_textsize_xxlarge_sp);
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
        ObservableExtensionsKt.appSubscribe$default(observeRepresentativeColor(viewState), UserProfileHeaderView.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    private final Observable<Integer> observeRepresentativeColor(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        GuildMember guildMember = viewState.getGuildMember();
        Observable<Integer> observableB0 = ObservableExtensionsKt.ui((guildMember == null || !guildMember.hasAvatar()) ? RepresentativeColorsKt.getUserRepresentativeColors().observeRepresentativeColor(viewState.getAvatarColorId()) : RepresentativeColorsKt.getGuildMemberRepresentativeColors().observeRepresentativeColor(viewState.getGuildMemberColorId())).a0(new ViewDetachedFromWindowObservable(this).observe()).b0(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableB0, "representativeColorObser….takeUntil { it != null }");
        return observableB0;
    }

    private final void onTapBanner() {
        this.onBannerPress.invoke();
    }

    private final void updateBannerBackgroundColorAsync(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Subscription subscription = this.setBannerBackgroundColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(observeRepresentativeColor(viewState), UserProfileHeaderView.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
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
            this.binding.f.setAvatarBackgroundColor(this.userProfileHeaderBackgroundColor);
            this.binding.c.setBackgroundColor(this.userProfileHeaderBackgroundColor);
        }
    }

    public final void setOnAvatarEdit(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onAvatarEdit = function0;
    }

    public final void setOnAvatarRepresentativeColorUpdated(Function1<? super Integer, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onAvatarRepresentativeColorUpdated = function1;
    }

    public final void setOnBadgeClick(Function1<? super Badge, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onBadgeClick = function1;
    }

    public final void setOnBannerPress(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onBannerPress = function0;
    }

    public final void updateBannerColor(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        Integer numValueOf;
        m.checkNotNullParameter(viewState, "viewState");
        String bannerColorHex = viewState.getBannerColorHex();
        if (bannerColorHex != null) {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(bannerColorHex));
            } catch (IllegalArgumentException e) {
                Logger.e$default(AppLog.g, b.d.b.a.a.w("failed to parse banner color string: ", bannerColorHex), e, null, 4, null);
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf != null) {
            this.binding.c.setBackgroundColor(numValueOf.intValue());
        }
        if (numValueOf == null) {
            updateBannerBackgroundColorAsync(viewState);
        }
    }

    public final void updateViewState(UserProfileHeaderViewModel.ViewState.Loaded viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        this.binding.f.setOnAvatarBitmapLoadedListener(new AnonymousClass1(viewState));
        this.binding.f.setOnClickListener(new AnonymousClass2(viewState));
        this.binding.f2166b.setOnClickListener(new AnonymousClass3(viewState));
        configureBanner(viewState);
        this.binding.f.a(new UserAvatarPresenceView.a(viewState.getUser(), viewState.getPresence(), viewState.getStreamContext(), viewState.getShowPresence(), viewState.getGuildMember()));
        configurePrimaryName(viewState);
        configureAka(viewState);
        configureSecondaryName(viewState);
        Badge.Companion companion = Badge.INSTANCE;
        User user = viewState.getUser();
        UserProfile userProfile = viewState.getUserProfile();
        boolean zIsMeUserPremium = viewState.isMeUserPremium();
        boolean zIsMeUserVerified = viewState.isMeUserVerified();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        this.badgesAdapter.setData(companion.getBadgesForUser(user, userProfile, zIsMeUserPremium, zIsMeUserVerified, context));
        Presence presence = viewState.getPresence();
        Activity customStatusActivity = presence != null ? PresenceUtils.INSTANCE.getCustomStatusActivity(presence) : null;
        if (customStatusActivity != null) {
            this.binding.i.setDraweeSpanStringBuilder(getCustomStatusDraweeSpanStringBuilder(customStatusActivity, viewState.getAllowAnimatedEmojis()));
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.i;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.userProfileHeaderCustomStatus");
        simpleDraweeSpanTextView.setVisibility(customStatusActivity != null ? 0 : 8);
        CardView cardView = this.binding.f2166b;
        m.checkNotNullExpressionValue(cardView, "binding.avatarEdit");
        cardView.setVisibility(viewState.getEditable() ? 0 : 8);
        CardView cardView2 = this.binding.d;
        m.checkNotNullExpressionValue(cardView2, "binding.bannerEdit");
        cardView2.setVisibility(viewState.getEditable() ? 0 : 8);
    }

    /* compiled from: UserProfileHeaderView.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<LayoutInflater, ViewGroup, BadgeViewHolder> {
        public AnonymousClass1() {
            super(2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final BadgeViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            m.checkNotNullParameter(layoutInflater, "inflater");
            m.checkNotNullParameter(viewGroup, "parent");
            View viewInflate = layoutInflater.inflate(R.layout.user_profile_header_badge, viewGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            ImageView imageView = (ImageView) viewInflate;
            UserProfileHeaderBadgeBinding userProfileHeaderBadgeBinding = new UserProfileHeaderBadgeBinding(imageView, imageView);
            m.checkNotNullExpressionValue(userProfileHeaderBadgeBinding, "UserProfileHeaderBadgeBi…(inflater, parent, false)");
            return new BadgeViewHolder(UserProfileHeaderView.this, userProfileHeaderBadgeBinding);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ BadgeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            return invoke2(layoutInflater, viewGroup);
        }
    }
}
