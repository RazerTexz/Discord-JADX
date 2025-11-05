package b.a.a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: CameraCapacityDialog.kt */
/* loaded from: classes.dex */
public final class j extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(j.class, "binding", "getBinding()Lcom/discord/databinding/CameraCapacityDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: CameraCapacityDialog.kt */
    /* renamed from: b.a.a.j$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(FragmentManager fragmentManager, int i) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putInt("ARG_MAX_VIDEO_CHANNEL_USERS", i);
            j jVar = new j();
            jVar.setArguments(bundle);
            jVar.show(fragmentManager, j.class.getSimpleName());
        }
    }

    /* compiled from: CameraCapacityDialog.kt */
    public static final /* synthetic */ class b extends d0.z.d.k implements Function1<View, b.a.i.e> {
        public static final b j = new b();

        public b() {
            super(1, b.a.i.e.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/CameraCapacityDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.a.i.e invoke(View view) {
            View view2 = view;
            d0.z.d.m.checkNotNullParameter(view2, "p1");
            int i = R.id.camera_capacity_body;
            TextView textView = (TextView) view2.findViewById(R.id.camera_capacity_body);
            if (textView != null) {
                i = R.id.camera_capacity_confirm;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.camera_capacity_confirm);
                if (materialButton != null) {
                    i = R.id.notice_header_container;
                    LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                    if (linearLayout != null) {
                        return new b.a.i.e((LinearLayout) view2, textView, materialButton, linearLayout);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: CameraCapacityDialog.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            j.this.dismiss();
        }
    }

    public j() {
        super(R.layout.camera_capacity_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        FragmentViewBindingDelegate fragmentViewBindingDelegate = this.binding;
        KProperty<?>[] kPropertyArr = j;
        ((b.a.i.e) fragmentViewBindingDelegate.getValue((Fragment) this, kPropertyArr[0])).c.setOnClickListener(new c());
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt("ARG_MAX_VIDEO_CHANNEL_USERS")) : null;
        TextView textView = ((b.a.i.e) this.binding.getValue((Fragment) this, kPropertyArr[0])).f102b;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.cameraCapacityBody");
        textView.setText(b.a.k.b.k(this, R.string.video_capacity_modal_body, new Object[]{String.valueOf(numValueOf)}, null, 4));
    }
}
