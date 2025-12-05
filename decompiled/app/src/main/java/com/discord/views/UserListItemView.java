package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.ViewUserListItemBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: UserListItemView.kt */
/* loaded from: classes2.dex */
public final class UserListItemView extends RelativeLayout {

    /* renamed from: j */
    public static final /* synthetic */ int f19171j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewUserListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserListItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_user_list_item, this);
        int i = C5419R.id.user_list_item_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.user_list_item_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.user_list_item_name;
            TextView textView = (TextView) findViewById(C5419R.id.user_list_item_name);
            if (textView != null) {
                i = C5419R.id.user_list_item_name_secondary;
                TextView textView2 = (TextView) findViewById(C5419R.id.user_list_item_name_secondary);
                if (textView2 != null) {
                    i = C5419R.id.user_list_item_status;
                    StatusView statusView = (StatusView) findViewById(C5419R.id.user_list_item_status);
                    if (statusView != null) {
                        ViewUserListItemBinding viewUserListItemBinding = new ViewUserListItemBinding(this, simpleDraweeView, textView, textView2, statusView);
                        Intrinsics3.checkNotNullExpressionValue(viewUserListItemBinding, "ViewUserListItemBinding.…ater.from(context), this)");
                        this.binding = viewUserListItemBinding;
                        setClickable(true);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }
}
