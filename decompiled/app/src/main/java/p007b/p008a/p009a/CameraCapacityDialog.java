package p007b.p008a.p009a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.CameraCapacityDialogBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CameraCapacityDialog.kt */
/* renamed from: b.a.a.j, reason: use source file name */
/* loaded from: classes.dex */
public final class CameraCapacityDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f391j = {outline.m846d0(CameraCapacityDialog.class, "binding", "getBinding()Lcom/discord/databinding/CameraCapacityDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: CameraCapacityDialog.kt */
    /* renamed from: b.a.a.j$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final void m137a(FragmentManager fragmentManager, int i) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_MAX_VIDEO_CHANNEL_USERS", i);
            CameraCapacityDialog cameraCapacityDialog = new CameraCapacityDialog();
            cameraCapacityDialog.setArguments(bundle);
            cameraCapacityDialog.show(fragmentManager, CameraCapacityDialog.class.getSimpleName());
        }
    }

    /* compiled from: CameraCapacityDialog.kt */
    /* renamed from: b.a.a.j$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, CameraCapacityDialogBinding> {

        /* renamed from: j */
        public static final b f394j = new b();

        public b() {
            super(1, CameraCapacityDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/CameraCapacityDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public CameraCapacityDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.camera_capacity_body;
            TextView textView = (TextView) view2.findViewById(C5419R.id.camera_capacity_body);
            if (textView != null) {
                i = C5419R.id.camera_capacity_confirm;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.camera_capacity_confirm);
                if (materialButton != null) {
                    i = C5419R.id.notice_header_container;
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
                    if (linearLayout != null) {
                        return new CameraCapacityDialogBinding((LinearLayout) view2, textView, materialButton, linearLayout);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: CameraCapacityDialog.kt */
    /* renamed from: b.a.a.j$c */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CameraCapacityDialog.this.dismiss();
        }
    }

    public CameraCapacityDialog() {
        super(C5419R.layout.camera_capacity_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.f394j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = f391j;
        ((CameraCapacityDialogBinding) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).f803c.setOnClickListener(new c());
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("ARG_MAX_VIDEO_CHANNEL_USERS")) : null;
        TextView textView = ((CameraCapacityDialogBinding) this.binding.getValue((Fragment) this, kPropertyArr[0])).f802b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cameraCapacityBody");
        textView.setText(FormatUtils.m219k(this, C5419R.string.video_capacity_modal_body, new Object[]{String.valueOf(numValueOf)}, null, 4));
    }
}
