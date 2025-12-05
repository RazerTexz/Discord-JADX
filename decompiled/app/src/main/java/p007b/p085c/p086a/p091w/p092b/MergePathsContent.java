package p007b.p085c.p086a.p091w.p092b;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import p007b.p085c.p086a.p091w.p093c.TransformKeyframeAnimation;
import p007b.p085c.p086a.p095y.p097l.MergePaths;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* renamed from: b.c.a.w.b.l, reason: use source file name */
/* loaded from: classes.dex */
public class MergePathsContent implements PathContent, GreedyContent {

    /* renamed from: a */
    public final Path f2540a = new Path();

    /* renamed from: b */
    public final Path f2541b = new Path();

    /* renamed from: c */
    public final Path f2542c = new Path();

    /* renamed from: d */
    public final List<PathContent> f2543d = new ArrayList();

    /* renamed from: e */
    public final MergePaths f2544e;

    public MergePathsContent(MergePaths mergePaths) {
        this.f2544e = mergePaths;
    }

    @TargetApi(19)
    /* renamed from: a */
    public final void m722a(Path.Op op) {
        Matrix matrixM747e;
        Matrix matrixM747e2;
        this.f2541b.reset();
        this.f2540a.reset();
        for (int size = this.f2543d.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.f2543d.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> listM716e = contentGroup.m716e();
                for (int size2 = listM716e.size() - 1; size2 >= 0; size2--) {
                    Path path = listM716e.get(size2).getPath();
                    TransformKeyframeAnimation transformKeyframeAnimation = contentGroup.f2492k;
                    if (transformKeyframeAnimation != null) {
                        matrixM747e2 = transformKeyframeAnimation.m747e();
                    } else {
                        contentGroup.f2484c.reset();
                        matrixM747e2 = contentGroup.f2484c;
                    }
                    path.transform(matrixM747e2);
                    this.f2541b.addPath(path);
                }
            } else {
                this.f2541b.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.f2543d.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> listM716e2 = contentGroup2.m716e();
            for (int i = 0; i < listM716e2.size(); i++) {
                Path path2 = listM716e2.get(i).getPath();
                TransformKeyframeAnimation transformKeyframeAnimation2 = contentGroup2.f2492k;
                if (transformKeyframeAnimation2 != null) {
                    matrixM747e = transformKeyframeAnimation2.m747e();
                } else {
                    contentGroup2.f2484c.reset();
                    matrixM747e = contentGroup2.f2484c;
                }
                path2.transform(matrixM747e);
                this.f2540a.addPath(path2);
            }
        } else {
            this.f2540a.set(pathContent2.getPath());
        }
        this.f2542c.op(this.f2540a, this.f2541b, op);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < this.f2543d.size(); i++) {
            this.f2543d.get(i).mo710b(list, list2);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.GreedyContent
    /* renamed from: e */
    public void mo721e(ListIterator<Content2> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content2 content2Previous = listIterator.previous();
            if (content2Previous instanceof PathContent) {
                this.f2543d.add((PathContent) content2Previous);
                listIterator.remove();
            }
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.PathContent
    public Path getPath() {
        this.f2542c.reset();
        MergePaths mergePaths = this.f2544e;
        if (mergePaths.f2773c) {
            return this.f2542c;
        }
        int iOrdinal = mergePaths.f2772b.ordinal();
        if (iOrdinal == 0) {
            for (int i = 0; i < this.f2543d.size(); i++) {
                this.f2542c.addPath(this.f2543d.get(i).getPath());
            }
        } else if (iOrdinal == 1) {
            m722a(Path.Op.UNION);
        } else if (iOrdinal == 2) {
            m722a(Path.Op.REVERSE_DIFFERENCE);
        } else if (iOrdinal == 3) {
            m722a(Path.Op.INTERSECT);
        } else if (iOrdinal == 4) {
            m722a(Path.Op.XOR);
        }
        return this.f2542c;
    }
}
