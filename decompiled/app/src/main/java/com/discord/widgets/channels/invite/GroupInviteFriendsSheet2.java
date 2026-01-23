package com.discord.widgets.channels.invite;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.GroupInviteFriendsBottomSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GroupInviteFriendsSheet2 extends FunctionReferenceImpl implements Function1<View, GroupInviteFriendsBottomSheetBinding> {
    public static final GroupInviteFriendsSheet2 INSTANCE = new GroupInviteFriendsSheet2();

    public GroupInviteFriendsSheet2() {
        super(1, GroupInviteFriendsBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GroupInviteFriendsBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ GroupInviteFriendsBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GroupInviteFriendsBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.chips_view;
        ChipsView chipsView = (ChipsView) view.findViewById(C5419R.id.chips_view);
        if (chipsView != null) {
            i = C5419R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
            if (recyclerView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = C5419R.id.search_icon;
                AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.search_icon);
                if (appCompatImageView != null) {
                    return new GroupInviteFriendsBottomSheetBinding(constraintLayout, chipsView, recyclerView, constraintLayout, appCompatImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
