package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.g.e.r;
import b.f.g.e.v;
import b.f.g.f.c;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewGuildRoleSubscriptionImageUploadBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildSubscriptionRoleImageUploadView.kt */
/* loaded from: classes2.dex */
public final class GuildSubscriptionRoleImageUploadView extends ConstraintLayout {
    private static final int CIRCLE_IMAGE_STYLE = 0;
    private static final int ROUNDED_IMAGE_STYLE = 1;
    private int avatarSize;
    private final ViewGuildRoleSubscriptionImageUploadBinding binding;
    private Function0<Unit> onImageChooserClickListener;
    private Function0<Unit> onImageRemovedListener;

    /* compiled from: GuildSubscriptionRoleImageUploadView.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView.this);
            if (function0Access$getOnImageChooserClickListener$p != null) {
            }
        }
    }

    /* compiled from: GuildSubscriptionRoleImageUploadView.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView.this);
            if (function0Access$getOnImageChooserClickListener$p != null) {
            }
        }
    }

    /* compiled from: GuildSubscriptionRoleImageUploadView.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView.this);
            if (function0Access$getOnImageChooserClickListener$p != null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingA = ViewGuildRoleSubscriptionImageUploadBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingA;
        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.avatar_size_huge);
        initialize$default(this, null, 1, null);
    }

    public static final /* synthetic */ Function0 access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView) {
        return guildSubscriptionRoleImageUploadView.onImageChooserClickListener;
    }

    public static final /* synthetic */ void access$setOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, Function0 function0) {
        guildSubscriptionRoleImageUploadView.onImageChooserClickListener = function0;
    }

    private final void initialize(AttributeSet attrs) {
        ScalingUtils$ScaleType scalingUtils$ScaleType;
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.a.GuildSubscriptionRoleImageUploadView;
        m.checkNotNullExpressionValue(iArr, "R.styleable.GuildSubscriptionRoleImageUploadView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        if (typedArrayObtainStyledAttributes.getBoolean(4, false)) {
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.a;
            scalingUtils$ScaleType = r.l;
        } else {
            ScalingUtils$ScaleType scalingUtils$ScaleType3 = ScalingUtils$ScaleType.a;
            scalingUtils$ScaleType = v.l;
        }
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        m.checkNotNullExpressionValue(hierarchy, "binding.guildSubscriptionImage.hierarchy");
        hierarchy.n(scalingUtils$ScaleType);
        int i = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (i == 0) {
            this.binding.d.setBackgroundResource(DrawableCompat.getThemedDrawableRes(this, R.attr.primary_700_circle, 0));
        } else if (i == 1) {
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            simpleDraweeView2.setBackgroundResource(R.drawable.drawable_rect_rounded_bg_tertiary);
            GenericDraweeHierarchy hierarchy2 = simpleDraweeView2.getHierarchy();
            m.checkNotNullExpressionValue(hierarchy2, "hierarchy");
            c cVar = new c();
            cVar.f523b = false;
            hierarchy2.s(cVar);
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildSubscriptio…            }\n          }");
        }
        String string = typedArrayObtainStyledAttributes.getString(3);
        if (string == null) {
            string = getContext().getString(R.string.guild_role_subscription_tier_detail_custom_image_label);
        }
        m.checkNotNullExpressionValue(string, "it.getString(R.styleable…etail_custom_image_label)");
        TextView textView = this.binding.f2195b;
        m.checkNotNullExpressionValue(textView, "binding.guildSubscriptionCustomImageTitle");
        textView.setText(string);
        String string2 = typedArrayObtainStyledAttributes.getString(0);
        if (string2 == null) {
            string2 = getContext().getString(R.string.guild_role_subscription_tier_detail_custom_image_description);
        }
        m.checkNotNullExpressionValue(string2, "it.getString(R.styleable…image_description\n      )");
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.guildSubscriptionUploadImageLabel");
        textView2.setText(string2);
        this.avatarSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(R.dimen.avatar_size_huge));
        typedArrayObtainStyledAttributes.recycle();
        this.binding.e.setOnClickListener(new AnonymousClass2());
        this.binding.d.setOnClickListener(new AnonymousClass3());
        this.binding.c.setOnClickListener(new AnonymousClass4());
    }

    public static /* synthetic */ void initialize$default(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        guildSubscriptionRoleImageUploadView.initialize(attributeSet);
    }

    private final void updateImageVisibility(boolean hasImage) {
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.guildSubscriptionEditImage");
        imageView.setVisibility(hasImage ? 0 : 8);
        if (hasImage) {
            this.binding.e.setText(R.string.avatar_upload_edit_media);
        } else {
            this.binding.e.setText(R.string.guild_role_subscription_tier_detail_custom_image_button);
        }
    }

    public final void configureUI(Function0<Unit> onImageRemoved, Function0<Unit> onImageChooserClicked) {
        m.checkNotNullParameter(onImageRemoved, "onImageRemoved");
        m.checkNotNullParameter(onImageChooserClicked, "onImageChooserClicked");
        this.onImageRemovedListener = onImageRemoved;
        this.onImageChooserClickListener = onImageChooserClicked;
    }

    public final void updateImage(String memberIcon, GuildRole guildRole) {
        if (!(memberIcon == null || t.isBlank(memberIcon))) {
            updateImage(memberIcon);
            return;
        }
        if (guildRole != null) {
            String icon = guildRole.getIcon();
            if (!(icon == null || t.isBlank(icon))) {
                SimpleDraweeView simpleDraweeView = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
                IconUtils.setIcon$default(simpleDraweeView, guildRole, R.dimen.avatar_size_huge, (MGImages.ChangeDetector) null, 8, (Object) null);
                updateImageVisibility(true);
                return;
            }
        }
        updateImage((String) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingA = ViewGuildRoleSubscriptionImageUploadBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingA;
        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.avatar_size_huge);
        initialize(attributeSet);
    }

    public final void updateImage(GuildRoleSubscriptionTier guildSubscriptionTier) {
        m.checkNotNullParameter(guildSubscriptionTier, "guildSubscriptionTier");
        String image = guildSubscriptionTier.getImage();
        if ((image == null || t.isBlank(image)) && guildSubscriptionTier.getImageAssetId() != null) {
            updateImage(guildSubscriptionTier.getApplicationId(), guildSubscriptionTier.getImageAssetId().longValue());
        } else {
            updateImage(guildSubscriptionTier.getImage());
        }
    }

    public /* synthetic */ GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingA = ViewGuildRoleSubscriptionImageUploadBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingA;
        this.avatarSize = getResources().getDimensionPixelSize(R.dimen.avatar_size_huge);
        initialize(attributeSet);
    }

    private final void updateImage(Long applicationId, long imageAssetId) {
        updateImage(IconUtils.INSTANCE.getStoreAssetImage(applicationId, String.valueOf(imageAssetId), this.avatarSize));
    }

    private final void updateImage(String imageUrl) {
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
        int i = this.avatarSize;
        IconUtils.setIcon$default(simpleDraweeView, imageUrl, i, i, false, null, null, 112, null);
        updateImageVisibility(!(imageUrl == null || t.isBlank(imageUrl)));
    }

    public /* synthetic */ GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
