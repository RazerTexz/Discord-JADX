package com.discord.views.user;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.CoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.ViewUserSummaryItemBinding;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: UserSummaryView.kt */
/* loaded from: classes2.dex */
public final class UserSummaryView extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final CutoutView.InterfaceC7075a.c cutoutStyle;

    /* renamed from: k, reason: from kotlin metadata */
    public int avatarSizePx;

    /* renamed from: l, reason: from kotlin metadata */
    public int overlapAmountPx;

    /* renamed from: m, reason: from kotlin metadata */
    public List<UserGuildMember> members;

    /* renamed from: n, reason: from kotlin metadata */
    public int maxAvatars;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserSummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.cutoutStyle = new CutoutView.InterfaceC7075a.c(0);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.avatarSizePx = (int) (16 * resources.getDisplayMetrics().density);
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        this.overlapAmountPx = (int) (4 * resources2.getDisplayMetrics().density);
        this.members = Collections2.emptyList();
        this.maxAvatars = 3;
        int[] iArr = C5419R.a.UserSummaryView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.UserSummaryView");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.avatarSizePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, this.avatarSizePx);
        this.overlapAmountPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.overlapAmountPx);
        this.maxAvatars = typedArrayObtainStyledAttributes.getInt(2, this.maxAvatars);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    public static /* synthetic */ void m8623b(UserSummaryView userSummaryView, List list, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        userSummaryView.m8624a(list, z2);
    }

    /* renamed from: a */
    public final void m8624a(List<UserGuildMember> members, boolean withFullAvatarAtEnd) {
        int id2;
        Intrinsics3.checkNotNullParameter(members, "members");
        if (!Intrinsics3.areEqual(members, this.members)) {
            this.members = members;
            int iCoerceAtMost = _Ranges.coerceAtMost(members.size(), this.maxAvatars);
            while (getChildCount() > iCoerceAtMost) {
                removeViewAt(getChildCount() - 1);
            }
            while (true) {
                id2 = 0;
                if (getChildCount() >= iCoerceAtMost) {
                    break;
                }
                int childCount = getChildCount();
                ViewUserSummaryItemBinding viewUserSummaryItemBindingM199a = ViewUserSummaryItemBinding.m199a(LayoutInflater.from(getContext()).inflate(C5419R.layout.view_user_summary_item, (ViewGroup) this, false));
                Intrinsics3.checkNotNullExpressionValue(viewUserSummaryItemBindingM199a, "ViewUserSummaryItemBindi…ext), this, false\n      )");
                CutoutView cutoutView = viewUserSummaryItemBindingM199a.f845a;
                cutoutView.setId(childCount + 10);
                int i = this.avatarSizePx;
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i, i);
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                layoutParams.setMarginStart(childCount != 0 ? this.avatarSizePx - this.overlapAmountPx : 0);
                if (childCount != 0) {
                    id2 = cutoutView.getId() - 1;
                }
                layoutParams.startToStart = id2;
                cutoutView.setLayoutParams(layoutParams);
                Intrinsics3.checkNotNullExpressionValue(cutoutView, "ViewUserSummaryItemBindi…      }\n        }\n      }");
                addView(cutoutView, cutoutView.getLayoutParams());
            }
            int i2 = iCoerceAtMost - 1;
            while (id2 < iCoerceAtMost) {
                ViewUserSummaryItemBinding viewUserSummaryItemBindingM199a2 = ViewUserSummaryItemBinding.m199a(getChildAt(id2));
                Intrinsics3.checkNotNullExpressionValue(viewUserSummaryItemBindingM199a2, "ViewUserSummaryItemBinding.bind(getChildAt(i))");
                viewUserSummaryItemBindingM199a2.f845a.setStyle((id2 == i2 && withFullAvatarAtEnd) ? CutoutView.InterfaceC7075a.d.f19062a : this.cutoutStyle);
                int mediaProxySize = IconUtils.getMediaProxySize(this.avatarSizePx);
                UserGuildMember userGuildMember = this.members.get(id2);
                String forGuildMemberOrUser$default = IconUtils.getForGuildMemberOrUser$default(IconUtils.INSTANCE, userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(mediaProxySize), false, 8, null);
                Intrinsics3.checkNotNullExpressionValue(viewUserSummaryItemBindingM199a2.f846b, "cutout.avatar");
                if (!Intrinsics3.areEqual(forGuildMemberOrUser$default, r5.getTag())) {
                    SimpleDraweeView simpleDraweeView = viewUserSummaryItemBindingM199a2.f846b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "cutout.avatar");
                    simpleDraweeView.setTag(forGuildMemberOrUser$default);
                    SimpleDraweeView simpleDraweeView2 = viewUserSummaryItemBindingM199a2.f846b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "cutout.avatar");
                    IconUtils.setIcon$default(simpleDraweeView2, forGuildMemberOrUser$default, C5419R.dimen.avatar_size_reply, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                }
                id2++;
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            m8624a(Collections2.listOf((Object[]) new UserGuildMember[]{new UserGuildMember(new CoreUser(0L, "mreynolds", null, null, false, false, 0, null, 0, 0, null, null, 4092, null), null, 2, null), new UserGuildMember(new CoreUser(1L, "itskaylee", null, null, false, false, 0, null, 0, 0, null, null, 4092, null), null, 2, null)}), true);
        }
    }
}
