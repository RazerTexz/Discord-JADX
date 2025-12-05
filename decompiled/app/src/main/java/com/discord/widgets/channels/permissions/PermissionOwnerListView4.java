package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.widgets.channels.permissions.PermissionOwnerListView;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PermissionOwnerListView.kt */
/* renamed from: com.discord.widgets.channels.permissions.PermissionOwnerListView$PermissionOwnerViewHolder$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class PermissionOwnerListView4 implements View.OnClickListener {
    public final /* synthetic */ PermissionOwnerListView.Item $item;
    public final /* synthetic */ Function0 $onRemoveClicked;
    public final /* synthetic */ PermissionOwnerListView.PermissionOwnerViewHolder this$0;

    public PermissionOwnerListView4(PermissionOwnerListView.PermissionOwnerViewHolder permissionOwnerViewHolder, PermissionOwnerListView.Item item, Function0 function0) {
        this.this$0 = permissionOwnerViewHolder;
        this.$item = item;
        this.$onRemoveClicked = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PermissionOwnerListView.RemoveStatus removeStatus = this.$item.getRemoveStatus();
        if (Intrinsics3.areEqual(removeStatus, PermissionOwnerListView.RemoveStatus.CanRemove.INSTANCE)) {
            this.$onRemoveClicked.invoke();
            return;
        }
        if (!Intrinsics3.areEqual(removeStatus, PermissionOwnerListView.RemoveStatus.IsRemoving.INSTANCE) && (removeStatus instanceof PermissionOwnerListView.RemoveStatus.CannotRemove)) {
            int iOrdinal = ((PermissionOwnerListView.RemoveStatus.CannotRemove) this.$item.getRemoveStatus()).getReason().ordinal();
            if (iOrdinal == 2) {
                ConstraintLayout constraintLayout = PermissionOwnerListView.PermissionOwnerViewHolder.access$getBinding$p(this.this$0).f15225a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
                Toast.makeText(constraintLayout.getContext(), C5419R.string.channel_permissions_remove_not_overwrite, 0).show();
            } else {
                if (iOrdinal != 3) {
                    return;
                }
                ConstraintLayout constraintLayout2 = PermissionOwnerListView.PermissionOwnerViewHolder.access$getBinding$p(this.this$0).f15225a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
                Toast.makeText(constraintLayout2.getContext(), C5419R.string.channel_permissions_cannot_edit_moderators, 0).show();
            }
        }
    }
}
