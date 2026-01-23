package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewGuildRoleSubscriptionImageUploadBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p109f.p132g.p142e.C1784r;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p132g.p143f.RoundingParams;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: GuildSubscriptionRoleImageUploadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildSubscriptionRoleImageUploadView extends ConstraintLayout {
    private static final int CIRCLE_IMAGE_STYLE = 0;
    private static final int ROUNDED_IMAGE_STYLE = 1;
    private int avatarSize;
    private final ViewGuildRoleSubscriptionImageUploadBinding binding;
    private Function0<Unit> onImageChooserClickListener;
    private Function0<Unit> onImageRemovedListener;

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$2 */
    /* JADX INFO: compiled from: GuildSubscriptionRoleImageUploadView.kt */
    public static final class ViewOnClickListenerC84352 implements View.OnClickListener {
        public ViewOnClickListenerC84352() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView.this);
            if (function0Access$getOnImageChooserClickListener$p != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$3 */
    /* JADX INFO: compiled from: GuildSubscriptionRoleImageUploadView.kt */
    public static final class ViewOnClickListenerC84363 implements View.OnClickListener {
        public ViewOnClickListenerC84363() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnImageChooserClickListener$p = GuildSubscriptionRoleImageUploadView.access$getOnImageChooserClickListener$p(GuildSubscriptionRoleImageUploadView.this);
            if (function0Access$getOnImageChooserClickListener$p != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView$initialize$4 */
    /* JADX INFO: compiled from: GuildSubscriptionRoleImageUploadView.kt */
    public static final class ViewOnClickListenerC84374 implements View.OnClickListener {
        public ViewOnClickListenerC84374() {
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
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingM8397a = ViewGuildRoleSubscriptionImageUploadBinding.m8397a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingM8397a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingM8397a;
        this.avatarSize = getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_huge);
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
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int[] iArr = C5419R.a.GuildSubscriptionRoleImageUploadView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.GuildSubscriptionRoleImageUploadView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        if (typedArrayObtainStyledAttributes.getBoolean(4, false)) {
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.f19495a;
            scalingUtils$ScaleType = C1784r.f3442l;
        } else {
            ScalingUtils$ScaleType scalingUtils$ScaleType3 = ScalingUtils$ScaleType.f19495a;
            scalingUtils$ScaleType = C1788v.f3446l;
        }
        SimpleDraweeView simpleDraweeView = this.binding.f15480d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        Intrinsics3.checkNotNullExpressionValue(hierarchy, "binding.guildSubscriptionImage.hierarchy");
        hierarchy.m8678n(scalingUtils$ScaleType);
        int i = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (i == 0) {
            this.binding.f15480d.setBackgroundResource(DrawableCompat.getThemedDrawableRes(this, C5419R.attr.primary_700_circle, 0));
        } else if (i == 1) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f15480d;
            simpleDraweeView2.setBackgroundResource(C5419R.drawable.drawable_rect_rounded_bg_tertiary);
            GenericDraweeHierarchy hierarchy2 = simpleDraweeView2.getHierarchy();
            Intrinsics3.checkNotNullExpressionValue(hierarchy2, "hierarchy");
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.f3472b = false;
            hierarchy2.m8683s(roundingParams);
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildSubscriptio…            }\n          }");
        }
        String string = typedArrayObtainStyledAttributes.getString(3);
        if (string == null) {
            string = getContext().getString(C5419R.string.guild_role_subscription_tier_detail_custom_image_label);
        }
        Intrinsics3.checkNotNullExpressionValue(string, "it.getString(R.styleable…etail_custom_image_label)");
        TextView textView = this.binding.f15478b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildSubscriptionCustomImageTitle");
        textView.setText(string);
        String string2 = typedArrayObtainStyledAttributes.getString(0);
        if (string2 == null) {
            string2 = getContext().getString(C5419R.string.guild_role_subscription_tier_detail_custom_image_description);
        }
        Intrinsics3.checkNotNullExpressionValue(string2, "it.getString(R.styleable…image_description\n      )");
        TextView textView2 = this.binding.f15482f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildSubscriptionUploadImageLabel");
        textView2.setText(string2);
        this.avatarSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_huge));
        typedArrayObtainStyledAttributes.recycle();
        this.binding.f15481e.setOnClickListener(new ViewOnClickListenerC84352());
        this.binding.f15480d.setOnClickListener(new ViewOnClickListenerC84363());
        this.binding.f15479c.setOnClickListener(new ViewOnClickListenerC84374());
    }

    public static /* synthetic */ void initialize$default(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        guildSubscriptionRoleImageUploadView.initialize(attributeSet);
    }

    private final void updateImageVisibility(boolean hasImage) {
        ImageView imageView = this.binding.f15479c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildSubscriptionEditImage");
        imageView.setVisibility(hasImage ? 0 : 8);
        if (hasImage) {
            this.binding.f15481e.setText(C5419R.string.avatar_upload_edit_media);
        } else {
            this.binding.f15481e.setText(C5419R.string.guild_role_subscription_tier_detail_custom_image_button);
        }
    }

    public final void configureUI(Function0<Unit> onImageRemoved, Function0<Unit> onImageChooserClicked) {
        Intrinsics3.checkNotNullParameter(onImageRemoved, "onImageRemoved");
        Intrinsics3.checkNotNullParameter(onImageChooserClicked, "onImageChooserClicked");
        this.onImageRemovedListener = onImageRemoved;
        this.onImageChooserClickListener = onImageChooserClicked;
    }

    public final void updateImage(String memberIcon, GuildRole guildRole) {
        if (!(memberIcon == null || StringsJVM.isBlank(memberIcon))) {
            updateImage(memberIcon);
            return;
        }
        if (guildRole != null) {
            String icon = guildRole.getIcon();
            if (!(icon == null || StringsJVM.isBlank(icon))) {
                SimpleDraweeView simpleDraweeView = this.binding.f15480d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
                IconUtils.setIcon$default(simpleDraweeView, guildRole, C5419R.dimen.avatar_size_huge, (MGImages.ChangeDetector) null, 8, (Object) null);
                updateImageVisibility(true);
                return;
            }
        }
        updateImage((String) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingM8397a = ViewGuildRoleSubscriptionImageUploadBinding.m8397a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingM8397a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingM8397a;
        this.avatarSize = getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_huge);
        initialize(attributeSet);
    }

    public final void updateImage(GuildRoleSubscriptionTier guildSubscriptionTier) {
        Intrinsics3.checkNotNullParameter(guildSubscriptionTier, "guildSubscriptionTier");
        String image = guildSubscriptionTier.getImage();
        if ((image == null || StringsJVM.isBlank(image)) && guildSubscriptionTier.getImageAssetId() != null) {
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
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingM8397a = ViewGuildRoleSubscriptionImageUploadBinding.m8397a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingM8397a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingM8397a;
        this.avatarSize = getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_huge);
        initialize(attributeSet);
    }

    private final void updateImage(Long applicationId, long imageAssetId) {
        updateImage(IconUtils.INSTANCE.getStoreAssetImage(applicationId, String.valueOf(imageAssetId), this.avatarSize));
    }

    private final void updateImage(String imageUrl) {
        SimpleDraweeView simpleDraweeView = this.binding.f15480d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
        int i = this.avatarSize;
        IconUtils.setIcon$default(simpleDraweeView, imageUrl, i, i, false, null, null, 112, null);
        updateImageVisibility(!(imageUrl == null || StringsJVM.isBlank(imageUrl)));
    }

    public /* synthetic */ GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
