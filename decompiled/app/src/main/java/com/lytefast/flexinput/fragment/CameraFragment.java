package com.lytefast.flexinput.fragment;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import b.b.a.b;
import b.o.a.k;
import b.o.a.l;
import b.o.a.m.e;
import b.o.a.m.f;
import b.o.a.r.g;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.managers.FileManager;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import defpackage.q;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CameraFragment.kt */
/* loaded from: classes3.dex */
public class CameraFragment extends Fragment {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    public View cameraContainer;

    /* renamed from: l, reason: from kotlin metadata */
    public CameraView cameraView;

    /* renamed from: m, reason: from kotlin metadata */
    public ViewStub permissionsViewStub;

    /* renamed from: n, reason: from kotlin metadata */
    public ImageView cameraFacingBtn;

    /* renamed from: o, reason: from kotlin metadata */
    public ImageView cameraFlashBtn;

    /* renamed from: p, reason: from kotlin metadata */
    public ImageView takePhotoBtn;

    /* renamed from: q, reason: from kotlin metadata */
    public ImageView launchCameraBtn;

    /* renamed from: r, reason: from kotlin metadata */
    public File photoFile;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean photoFilePending;

    /* compiled from: java-style lambda group */
    /* loaded from: classes.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            List listEmptyList;
            Collection<f> collectionB;
            List listEmptyList2;
            Collection<e> collectionA;
            int i = this.j;
            if (i == 0) {
                CameraView cameraView = ((CameraFragment) this.k).cameraView;
                if (cameraView == null) {
                    m.throwUninitializedPropertyAccessException("cameraView");
                }
                cameraView.f3176z.O0(new l.a());
                return;
            }
            Integer num = null;
            if (i == 1) {
                CameraFragment cameraFragment = (CameraFragment) this.k;
                cameraFragment.photoFile = null;
                cameraFragment.photoFilePending = true;
                CameraView cameraView2 = cameraFragment.cameraView;
                if (cameraView2 == null) {
                    m.throwUninitializedPropertyAccessException("cameraView");
                }
                cameraView2.close();
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    throw null;
                }
                CameraFragment cameraFragment2 = (CameraFragment) this.k;
                CameraView cameraView3 = cameraFragment2.cameraView;
                if (cameraView3 == null) {
                    m.throwUninitializedPropertyAccessException("cameraView");
                }
                b.o.a.c cameraOptions = cameraView3.getCameraOptions();
                if (cameraOptions == null || (collectionA = cameraOptions.a()) == null || (listEmptyList2 = u.toList(collectionA)) == null) {
                    listEmptyList2 = n.emptyList();
                }
                if (listEmptyList2.size() <= 1) {
                    return;
                }
                CameraView cameraView4 = cameraFragment2.cameraView;
                if (cameraView4 == null) {
                    m.throwUninitializedPropertyAccessException("cameraView");
                }
                e facing = cameraView4.getFacing();
                m.checkNotNullExpressionValue(facing, "cameraView.facing");
                Iterator<Integer> it = n.getIndices(listEmptyList2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Integer next = it.next();
                    if (facing == ((e) listEmptyList2.get(next.intValue()))) {
                        num = next;
                        break;
                    }
                }
                Integer num2 = num;
                e eVar = (e) u.getOrNull(listEmptyList2, ((num2 != null ? num2.intValue() : 0) + 1) % listEmptyList2.size());
                if (eVar != null) {
                    cameraFragment2.g();
                    CameraView cameraView5 = cameraFragment2.cameraView;
                    if (cameraView5 == null) {
                        m.throwUninitializedPropertyAccessException("cameraView");
                    }
                    cameraView5.setFacing(eVar);
                    return;
                }
                return;
            }
            CameraFragment cameraFragment3 = (CameraFragment) this.k;
            CameraView cameraView6 = cameraFragment3.cameraView;
            if (cameraView6 == null) {
                m.throwUninitializedPropertyAccessException("cameraView");
            }
            b.o.a.c cameraOptions2 = cameraView6.getCameraOptions();
            if (cameraOptions2 == null || (collectionB = cameraOptions2.b()) == null || (listEmptyList = u.toList(collectionB)) == null) {
                listEmptyList = n.emptyList();
            }
            if (listEmptyList.size() <= 1) {
                return;
            }
            CameraView cameraView7 = cameraFragment3.cameraView;
            if (cameraView7 == null) {
                m.throwUninitializedPropertyAccessException("cameraView");
            }
            f flash = cameraView7.getFlash();
            m.checkNotNullExpressionValue(flash, "cameraView.flash");
            Iterator<Integer> it2 = n.getIndices(listEmptyList).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Integer next2 = it2.next();
                if (flash == ((f) listEmptyList.get(next2.intValue()))) {
                    num = next2;
                    break;
                }
            }
            Integer num3 = num;
            f fVar = (f) u.getOrNull(listEmptyList, ((num3 != null ? num3.intValue() : 0) + 1) % listEmptyList.size());
            if (fVar != null) {
                try {
                    CameraView cameraView8 = cameraFragment3.cameraView;
                    if (cameraView8 == null) {
                        m.throwUninitializedPropertyAccessException("cameraView");
                    }
                    cameraView8.setFlash(fVar);
                    cameraFragment3.h();
                } catch (Exception e) {
                    String string = cameraFragment3.getString(R.h.camera_unknown_error);
                    m.checkNotNullExpressionValue(string, "getString(R.string.camera_unknown_error)");
                    CameraFragment.l(cameraFragment3, string, e, true, null, 8, null);
                }
            }
        }
    }

    /* compiled from: CameraFragment.kt */
    /* renamed from: com.lytefast.flexinput.fragment.CameraFragment$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: CameraFragment.kt */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            b<Object> bVarK = cameraFragment.k();
            if (bVarK != null) {
                bVarK.requestMediaPermissions(q.k);
            }
        }
    }

    /* compiled from: CameraFragment.kt */
    public static final class d extends b.o.a.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f3164b;

        /* compiled from: CameraFragment.kt */
        public static final class a implements k {
            public a() {
            }

            @Override // b.o.a.k
            public final void a(File file) {
                if (file != null) {
                    Companion companion = CameraFragment.INSTANCE;
                    Context context = d.this.f3164b.getContext();
                    m.checkNotNullExpressionValue(context, "view.context");
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                    b<Object> bVarK = CameraFragment.this.k();
                    if (bVarK != null) {
                        bVarK.f(b.b.a.g.a.a(file));
                    }
                }
            }
        }

        public d(View view) {
            this.f3164b = view;
        }

        @Override // b.o.a.a
        public void a() {
            CameraFragment cameraFragment = CameraFragment.this;
            if (cameraFragment.photoFilePending) {
                b<Object> bVarK = cameraFragment.k();
                FileManager fileManager = bVarK != null ? bVarK.getFileManager() : null;
                File fileB = fileManager != null ? fileManager.b() : null;
                if (fileB == null) {
                    CameraFragment.j(cameraFragment, 0, 0, 3, null);
                    return;
                }
                Context contextRequireContext = cameraFragment.requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                Uri uriA = fileManager.a(contextRequireContext, fileB);
                Intent intentAddFlags = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriA).addFlags(2);
                Context contextRequireContext2 = cameraFragment.requireContext();
                m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                m.checkNotNullExpressionValue(intentAddFlags, "intent");
                List<ResolveInfo> listQueryIntentActivities = contextRequireContext2.getPackageManager().queryIntentActivities(intentAddFlags, 65536);
                m.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…nager.MATCH_DEFAULT_ONLY)");
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    contextRequireContext2.grantUriPermission(it.next().activityInfo.packageName, uriA, 3);
                }
                m.checkNotNullExpressionValue(intentAddFlags, "Intent(MediaStore.ACTION…nt, photoUri)\n          }");
                cameraFragment.photoFile = fileB;
                try {
                    cameraFragment.startActivityForResult(intentAddFlags, 4567);
                } catch (ActivityNotFoundException unused) {
                    CameraFragment.j(cameraFragment, 0, 0, 3, null);
                }
            }
        }

        @Override // b.o.a.a
        public void b(CameraException cameraException) {
            m.checkNotNullParameter(cameraException, "exception");
            CameraFragment cameraFragment = CameraFragment.this;
            String string = cameraFragment.getString(R.h.camera_unknown_error);
            m.checkNotNullExpressionValue(string, "getString(R.string.camera_unknown_error)");
            CameraFragment.l(cameraFragment, string, cameraException, true, null, 8, null);
        }

        @Override // b.o.a.a
        public void c(b.o.a.c cVar) {
            m.checkNotNullParameter(cVar, "cameraOptions");
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            cameraFragment.h();
            CameraFragment.this.g();
            ImageView imageView = CameraFragment.this.cameraFacingBtn;
            if (imageView == null) {
                m.throwUninitializedPropertyAccessException("cameraFacingBtn");
            }
            imageView.setVisibility(cVar.a().size() > 1 ? 0 : 8);
            ImageView imageView2 = CameraFragment.this.cameraFlashBtn;
            if (imageView2 == null) {
                m.throwUninitializedPropertyAccessException("cameraFlashBtn");
            }
            imageView2.setVisibility(cVar.b().size() > 1 ? 0 : 8);
        }

        @Override // b.o.a.a
        public void d(l lVar) {
            FileManager fileManager;
            File fileB;
            m.checkNotNullParameter(lVar, "result");
            CameraFragment cameraFragment = CameraFragment.this;
            Companion companion = CameraFragment.INSTANCE;
            b<Object> bVarK = cameraFragment.k();
            if (bVarK == null || (fileManager = bVarK.getFileManager()) == null || (fileB = fileManager.b()) == null) {
                return;
            }
            a aVar = new a();
            byte[] bArr = lVar.a;
            b.o.a.b bVar = b.o.a.e.a;
            g.a(new b.o.a.d(bArr, fileB, new Handler(), aVar));
        }
    }

    public static /* synthetic */ void j(CameraFragment cameraFragment, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 4567;
        }
        cameraFragment.i(i, i2);
    }

    public static void l(CameraFragment cameraFragment, String str, Exception exc, boolean z2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            exc = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        String str3 = (i & 8) != 0 ? str : null;
        Objects.requireNonNull(cameraFragment);
        Log.e("Discord", str, exc);
        if (z2) {
            Toast.makeText(cameraFragment.getContext(), str3, 0).show();
        }
    }

    public final void g() {
        ImageView imageView = this.cameraFacingBtn;
        if (imageView == null) {
            m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal = cameraView.getFacing().ordinal();
        int i = (iOrdinal == 0 || iOrdinal != 1) ? R.e.ic_camera_front_white_24dp : R.e.ic_camera_rear_white_24dp;
        imageView.setImageResource(i);
    }

    public final void h() {
        ImageView imageView = this.cameraFlashBtn;
        if (imageView == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal = cameraView.getFlash().ordinal();
        imageView.setImageResource(iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 3 ? R.e.ic_flash_auto_24dp : R.e.ic_flash_torch_24dp : R.e.ic_flash_on_24dp : R.e.ic_flash_off_24dp);
        ImageView imageView2 = this.cameraFlashBtn;
        if (imageView2 == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        int iOrdinal2 = cameraView2.getFlash().ordinal();
        String string = iOrdinal2 != 0 ? iOrdinal2 != 1 ? (iOrdinal2 == 2 || iOrdinal2 != 3) ? getString(R.h.flash_auto) : getString(R.h.flash_torch) : getString(R.h.flash_on) : getString(R.h.flash_off);
        imageView2.setContentDescription(string);
    }

    public final void i(int resultCode, int requestCode) {
        File file;
        if (requestCode != 4567) {
            return;
        }
        if (resultCode == -1) {
            File file2 = this.photoFile;
            if (file2 != null) {
                Context contextRequireContext = requireContext();
                m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                contextRequireContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
                b<Object> bVarK = k();
                if (bVarK != null) {
                    bVarK.f(b.b.a.g.a.a(file2));
                }
            }
        } else if (resultCode != 0 && (file = this.photoFile) != null) {
            String string = getString(R.h.camera_intent_result_error);
            m.checkNotNullExpressionValue(string, "getString(R.string.camera_intent_result_error)");
            Toast.makeText(getContext(), string, 0).show();
            file.delete();
        }
        CameraView cameraView = this.cameraView;
        if (cameraView == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView.open();
        this.photoFile = null;
        this.photoFilePending = false;
    }

    public final b<Object> k() {
        Fragment parentFragment = getParentFragment();
        Fragment parentFragment2 = parentFragment != null ? parentFragment.getParentFragment() : null;
        return (b) (parentFragment2 instanceof b ? parentFragment2 : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        i(resultCode, requestCode);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.g.fragment_camera, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Context context;
        PackageManager packageManager;
        super.onResume();
        View view = getView();
        boolean z2 = (view == null || (context = view.getContext()) == null || (packageManager = context.getPackageManager()) == null || !packageManager.hasSystemFeature("android.hardware.camera.any")) ? false : true;
        b<Object> bVarK = k();
        boolean z3 = bVarK != null && bVarK.hasMediaPermissions();
        if (z2 && z3) {
            View view2 = this.cameraContainer;
            if (view2 == null) {
                m.throwUninitializedPropertyAccessException("cameraContainer");
            }
            view2.setVisibility(0);
            ViewStub viewStub = this.permissionsViewStub;
            if (viewStub == null) {
                m.throwUninitializedPropertyAccessException("permissionsViewStub");
            }
            if (m.areEqual(viewStub.getTag(), Boolean.TRUE)) {
                ViewStub viewStub2 = this.permissionsViewStub;
                if (viewStub2 == null) {
                    m.throwUninitializedPropertyAccessException("permissionsViewStub");
                }
                viewStub2.setVisibility(8);
                return;
            }
            return;
        }
        View view3 = this.cameraContainer;
        if (view3 == null) {
            m.throwUninitializedPropertyAccessException("cameraContainer");
        }
        view3.setVisibility(8);
        ViewStub viewStub3 = this.permissionsViewStub;
        if (viewStub3 == null) {
            m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        if (viewStub3.getTag() != null) {
            ViewStub viewStub4 = this.permissionsViewStub;
            if (viewStub4 == null) {
                m.throwUninitializedPropertyAccessException("permissionsViewStub");
            }
            viewStub4.setVisibility(0);
            return;
        }
        ViewStub viewStub5 = this.permissionsViewStub;
        if (viewStub5 == null) {
            m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        viewStub5.setTag(Boolean.TRUE);
        ViewStub viewStub6 = this.permissionsViewStub;
        if (viewStub6 == null) {
            m.throwUninitializedPropertyAccessException("permissionsViewStub");
        }
        View viewInflate = viewStub6.inflate();
        viewInflate.findViewById(R.f.permissions_required_action_btn).setOnClickListener(new c());
        View viewFindViewById = viewInflate.findViewById(R.f.permissions_required_text);
        m.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<TextVi…ermissions_required_text)");
        b.a.k.b.n((TextView) viewFindViewById, R.h.system_permission_request_camera, new Object[0], null, 4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.f.permissions_view_stub);
        m.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.permissions_view_stub)");
        this.permissionsViewStub = (ViewStub) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.f.camera_container);
        m.checkNotNullExpressionValue(viewFindViewById2, "view.findViewById(R.id.camera_container)");
        this.cameraContainer = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.f.camera_view);
        m.checkNotNullExpressionValue(viewFindViewById3, "view.findViewById(R.id.camera_view)");
        CameraView cameraView = (CameraView) viewFindViewById3;
        this.cameraView = cameraView;
        if (cameraView == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView.setLifecycleOwner(getViewLifecycleOwner());
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView2.setPlaySounds(false);
        CameraView cameraView3 = this.cameraView;
        if (cameraView3 == null) {
            m.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView3.D.add(new d(view));
        View viewFindViewById4 = view.findViewById(R.f.take_photo_btn);
        m.checkNotNullExpressionValue(viewFindViewById4, "view.findViewById(R.id.take_photo_btn)");
        ImageView imageView = (ImageView) viewFindViewById4;
        this.takePhotoBtn = imageView;
        if (imageView == null) {
            m.throwUninitializedPropertyAccessException("takePhotoBtn");
        }
        imageView.setOnClickListener(new a(0, this));
        ImageView imageView2 = this.takePhotoBtn;
        if (imageView2 == null) {
            m.throwUninitializedPropertyAccessException("takePhotoBtn");
        }
        imageView2.setImageTintList(null);
        View viewFindViewById5 = view.findViewById(R.f.launch_camera_btn);
        m.checkNotNullExpressionValue(viewFindViewById5, "view.findViewById(R.id.launch_camera_btn)");
        ImageView imageView3 = (ImageView) viewFindViewById5;
        this.launchCameraBtn = imageView3;
        if (imageView3 == null) {
            m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView3.setOnClickListener(new a(1, this));
        ImageView imageView4 = this.launchCameraBtn;
        if (imageView4 == null) {
            m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView4.setImageTintList(ColorStateList.valueOf(-1));
        ImageView imageView5 = this.launchCameraBtn;
        if (imageView5 == null) {
            m.throwUninitializedPropertyAccessException("launchCameraBtn");
        }
        imageView5.setImageResource(R.e.ic_launch_24dp);
        View viewFindViewById6 = view.findViewById(R.f.camera_flash_btn);
        m.checkNotNullExpressionValue(viewFindViewById6, "view.findViewById(R.id.camera_flash_btn)");
        ImageView imageView6 = (ImageView) viewFindViewById6;
        this.cameraFlashBtn = imageView6;
        if (imageView6 == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView6.setOnClickListener(new a(2, this));
        ImageView imageView7 = this.cameraFlashBtn;
        if (imageView7 == null) {
            m.throwUninitializedPropertyAccessException("cameraFlashBtn");
        }
        imageView7.setImageTintList(ColorStateList.valueOf(-1));
        View viewFindViewById7 = view.findViewById(R.f.camera_facing_btn);
        m.checkNotNullExpressionValue(viewFindViewById7, "view.findViewById(R.id.camera_facing_btn)");
        ImageView imageView8 = (ImageView) viewFindViewById7;
        this.cameraFacingBtn = imageView8;
        if (imageView8 == null) {
            m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView8.setOnClickListener(new a(3, this));
        ImageView imageView9 = this.cameraFacingBtn;
        if (imageView9 == null) {
            m.throwUninitializedPropertyAccessException("cameraFacingBtn");
        }
        imageView9.setImageTintList(ColorStateList.valueOf(-1));
    }
}
