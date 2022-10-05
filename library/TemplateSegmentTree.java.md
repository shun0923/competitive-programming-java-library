---
data:
  _extendedDependsOn:
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TemplateSegmentTree_Composite_test.java
    title: library/TemplateSegmentTree_Composite_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateSegmentTree_test.java
    title: library/TemplateSegmentTree_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.function.*;\nimport library.SimpleUtil;\n\
    \nclass TemplateSegmentTree<T> {\n\tprivate Supplier<T> eSupplier;\n\tprivate\
    \ T e;\n\tprivate BinaryOperator<T> f;\n\n\tprivate int n;\n\tprivate T nodes[];\n\
    \tprivate int rangeL[];\n\tprivate int rangeR[];\n\n\t// O(N)\n\tpublic TemplateSegmentTree(T[]\
    \ a, Supplier<T> eSupplier, BinaryOperator<T> f) {\n\t\tthis(a.length, eSupplier,\
    \ f);\n\t\tSystem.arraycopy(a, 0, nodes, n, a.length);\n\t\tfor(int i = n - 1;\
    \ i > 0; i --) nodes[i] = f.apply(nodes[i << 1], nodes[(i << 1) + 1]);\n\t}\n\t\
    public TemplateSegmentTree(int len, Supplier<T> xSupplier, Supplier<T> eSupplier,\
    \ BinaryOperator<T> f) {\n\t\tthis(len, eSupplier, f);\n\t\tfor(int i = 0; i <\
    \ len; i ++) nodes[n + i] = xSupplier.get();\n\t\tfor(int i = n - 1; i > 0; i\
    \ --) nodes[i] = f.apply(nodes[i << 1], nodes[(i << 1) + 1]);\n\t}\n\t@SuppressWarnings(\"\
    unchecked\")\n\tpublic TemplateSegmentTree(int len, Supplier<T> eSupplier, BinaryOperator<T>\
    \ f) {\n\t\tSimpleUtil.nonNegativeCheck(len);\n\t\tthis.eSupplier = eSupplier;\n\
    \t\tthis.e = eSupplier.get();\n\t\tthis.f = f;\n\t\tn = 1;\n\t\twhile(n < len)\
    \ n <<= 1;\n\t\tnodes = (T[]) new Object[n << 1];\n\t\tfor(int i = 0; i < nodes.length;\
    \ i ++) nodes[i] = eSupplier.get();\n\t\trangeL = new int[n << 1];\n\t\trangeR\
    \ = new int[n << 1];\n\t\tfor(int i = 0; i < n; i ++) { rangeL[i + n] = i; rangeR[i\
    \ + n] = i + 1; }\n\t\tfor(int i = n - 1; i > 0; i --) {\n\t\t\trangeL[i] = rangeL[i\
    \ << 1]; rangeR[i] = rangeR[(i << 1) + 1];\n\t\t}\n\t}\n\n\n\t// O(logN)\n\tpublic\
    \ void set(int i, T val) {\n\t\tSimpleUtil.rangeCheck(i, n);\n\t\ti += n;\n\t\t\
    nodes[i] = val;\n\t\twhile(i > 1) {\n\t\t\ti >>= 1;\n\t\t\tnodes[i] = f.apply(nodes[i\
    \ << 1], nodes[(i << 1) + 1]);\n\t\t}\n\t}\n\tpublic void update(int i, T val)\
    \ { set(i, f.apply(nodes[i + n], val)); }\n\n\tpublic T get(int i) { return nodes[i\
    \ + n]; } // O(1)\n\n\tpublic T find(int l, int r) { // O(logN)\n\t\tSimpleUtil.inclusiveRangeCheck(l,\
    \ n);\n\t\tSimpleUtil.inclusiveRangeCheck(r, n);\n\t\tSimpleUtil.assertion(l <=\
    \ r, \"l is larger than r.\");\n\t\tl += n; r += n;\n\t\tT xL = eSupplier.get();\n\
    \t\tT xR = eSupplier.get();\n\t\twhile(l < r) {\n\t\t\tif((l & 1) != 0) xL = f.apply(xL,\
    \ nodes[l ++]);\n\t\t\tif((r & 1) != 0) xR = f.apply(nodes[-- r], xR);\n\t\t\t\
    l >>= 1; r >>= 1;\n\t\t}\n\t\treturn f.apply(xL, xR);\n\t}\n\n\t// min idx s.t.\
    \ a<=idx<b && check(find(a,idx)) && !check(find(a,idx+1)) // O(logN)\n\tpublic\
    \ int findLeftmost(Predicate<T> check) { return findLeftmost(0, check); }\n\t\
    public int findLeftmost(int l, Predicate<T> check) { return findLeftmost(l, n,\
    \ check); }\n\tpublic int findLeftmost(int l, int r, Predicate<T> check) {\n\t\
    \tSimpleUtil.inclusiveRangeCheck(l, n);\n\t\tSimpleUtil.inclusiveRangeCheck(r,\
    \ n);\n\t\tSimpleUtil.assertion(l <= r, \"l is larger than r.\");\n\t\tT crt =\
    \ eSupplier.get();\n\t\tint idx;\n\t\tfor(idx = l + n; idx < n << 1 && l < r;\
    \ ){\n\t\t\tT tmp = f.apply(crt, nodes[idx]);\n\t\t\tif(rangeR[idx] <= r && check.test(tmp))\
    \ {\n\t\t\t\tcrt = tmp;\n\t\t\t\tl = rangeR[idx ++];\n\t\t\t\tif((idx & 1) ==\
    \ 0) idx >>= 1;\n\t\t\t}else idx <<= 1;\n\t\t}\n\t\treturn l >= r ? r : l;\n\t\
    }\n\t// max idx s.t. a<=idx<b && !check(find(idx-1,b)) && check(find(idx,b)) //\
    \ O(logN)\n\tpublic int findRightmost(Predicate<T> check) { return findRightmost(n,\
    \ check); }\n\tpublic int findRightmost(int r, Predicate<T> check) { return findRightmost(0,\
    \ r, check); }\n\tpublic int findRightmost(int l, int r, Predicate<T> check) {\n\
    \t\tSimpleUtil.inclusiveRangeCheck(l, n);\n\t\tSimpleUtil.inclusiveRangeCheck(r,\
    \ n);\n\t\tSimpleUtil.assertion(l <= r, \"l is larger than r.\");\n\t\tT crt =\
    \ eSupplier.get();\n\t\tint idx;\n\t\tfor(idx = r + n - 1; idx < n << 1 && r >\
    \ l; ){\n\t\t\tT tmp = f.apply(nodes[idx], crt);\n\t\t\tif(rangeL[idx] >= l &&\
    \ check.test(tmp)) {\n\t\t\t\tcrt = tmp;\n\t\t\t\tr = rangeL[idx --];\n\t\t\t\t\
    if((idx & 1) != 0) idx >>= 1;\n\t\t\t}else idx = (idx << 1) + 1;\n\t\t}\n\t\t\
    return r <= l ? l : r;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  isVerificationFile: false
  path: library/TemplateSegmentTree.java
  requiredBy: []
  timestamp: '2022-10-05 20:31:46+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TemplateSegmentTree_Composite_test.java
  - library/TemplateSegmentTree_test.java
documentation_of: library/TemplateSegmentTree.java
layout: document
redirect_from:
- /library/library/TemplateSegmentTree.java
- /library/library/TemplateSegmentTree.java.html
title: library/TemplateSegmentTree.java
---
