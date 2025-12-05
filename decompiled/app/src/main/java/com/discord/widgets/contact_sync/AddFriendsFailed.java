package com.discord.widgets.contact_sync;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AddFriendsFailed.kt */
/* loaded from: classes2.dex */
public final class AddFriendsFailed extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(AddFriendsFailed.class, "binding", "getBinding()Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onClose;

    /* compiled from: AddFriendsFailed.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AddFriendsFailed show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            AddFriendsFailed addFriendsFailed = new AddFriendsFailed();
            addFriendsFailed.show(fragmentManager, AddFriendsFailed.class.getSimpleName());
            return addFriendsFailed;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AddFriendsFailed.kt */
    /* renamed from: com.discord.widgets.contact_sync.AddFriendsFailed$onViewBound$1 */
    public static final class ViewOnClickListenerC82051 implements View.OnClickListener {
        public ViewOnClickListenerC82051() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AddFriendsFailed.this.dismiss();
            Function0<Unit> onClose = AddFriendsFailed.this.getOnClose();
            if (onClose != null) {
                onClose.invoke();
            }
        }
    }

    public AddFriendsFailed() {
        super(C5419R.layout.view_dialog_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, AddFriendsFailed2.INSTANCE, null, 2, null);
    }

    private final ViewDialogConfirmationBinding getBinding() {
        return (ViewDialogConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final Function0<Unit> getOnClose() {
        return this.onClose;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15423d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        textView.setText(FormatUtils.m219k(this, C5419R.string.friend_request_failed_header, new Object[0], null, 4));
        TextView textView2 = getBinding().f15424e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
        textView2.setText(FormatUtils.m219k(this, C5419R.string.friend_request_failed_body, new Object[0], null, 4));
        MaterialButton materialButton = getBinding().f15422c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationConfirm");
        materialButton.setText(FormatUtils.m219k(this, C5419R.string.okay, new Object[0], null, 4));
        getBinding().f15422c.setOnClickListener(new ViewOnClickListenerC82051());
        MaterialButton materialButton2 = getBinding().f15421b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationCancel");
        materialButton2.setVisibility(8);
    }

    public final void setOnClose(Function0<Unit> function0) {
        this.onClose = function0;
    }
}
