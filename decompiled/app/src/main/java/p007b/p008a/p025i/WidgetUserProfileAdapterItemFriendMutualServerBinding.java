package p007b.p008a.p025i;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: renamed from: b.a.i.f6, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserProfileAdapterItemFriendMutualServerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserProfileAdapterItemFriendMutualServerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f849a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f850b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f851c;

    public WidgetUserProfileAdapterItemFriendMutualServerBinding(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f849a = relativeLayout;
        this.f850b = simpleDraweeView;
        this.f851c = textView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetUserProfileAdapterItemFriendMutualServerBinding m200a(@NonNull View view) {
        int i = C5419R.id.user_profile_adapter_item_friend_mutual_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.user_profile_adapter_item_friend_mutual_image);
        if (simpleDraweeView != null) {
            i = C5419R.id.user_profile_adapter_item_friend_mutual_text;
            TextView textView = (TextView) view.findViewById(C5419R.id.user_profile_adapter_item_friend_mutual_text);
            if (textView != null) {
                return new WidgetUserProfileAdapterItemFriendMutualServerBinding((RelativeLayout) view, simpleDraweeView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f849a;
    }
}
