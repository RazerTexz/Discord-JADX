package p007b.p452o.p453a.p464o;

import androidx.annotation.NonNull;

/* compiled from: NoFilter.java */
/* renamed from: b.o.a.o.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class NoFilter extends BaseFilter {
    @Override // p007b.p452o.p453a.p464o.Filter2
    @NonNull
    /* renamed from: h */
    public String mo7375h() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    }
}
