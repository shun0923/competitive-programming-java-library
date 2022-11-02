---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\n\nclass Sort {\n\t// N=array.length\
    \ N>=10^5\n\tpublic static final <T extends Comparable<? super T>> void quickSort(final\
    \ T[] array) { quickSort(array, 0, array.length, Comparator.naturalOrder()); }\
    \ // O(NlogN)\n\tpublic static final <T extends Comparable<? super T>> void quickSort(final\
    \ T[] array, final Comparator<? super T> c) { quickSort(array, 0, array.length,\
    \ c); } // O(NlogN)\n\tpublic static final <T extends Comparable<? super T>> void\
    \ quickSort(final T[] array, final int from, final int to, final Comparator<?\
    \ super T> c) { // O(NlogN)\n\t\tif(from >= to) return;\n\t\tint range = to -\
    \ from;\n\t\tT pivot = median3(array[from], array[(from + to) / 2], array[to -\
    \ 1], c);\n\t\tint curFrom = from;\n\t\tint curTo = to - 1;\n\t\tdo {\n\t\t\t\
    while(c.compare(array[curFrom], pivot) < 0) curFrom ++;\n\t\t\twhile(c.compare(pivot,\
    \ array[curTo]) < 0) curTo --;\n\t\t\tif(curFrom <= curTo) {\n\t\t\t\tT tmp =\
    \ array[curFrom];\n\t\t\t\tarray[curFrom] = array[curTo];\n\t\t\t\tarray[curTo]\
    \ = tmp;\n\t\t\t\tcurFrom ++;\n\t\t\t\tcurTo --;\n\t\t\t}\n\t\t}while(curFrom\
    \ <= curTo);\n\t\n\t\tif(from < curTo + 1) quickSort(array, from, curTo + 1, c);\n\
    \t\tif(curFrom < to - 1) quickSort(array, curFrom, to, c);\n\t}\n\tprivate static\
    \ final <T extends Comparable<? super T>> T median3(final T x, final T y, final\
    \ T z, final Comparator<? super T> c) {\n\t\treturn c.compare(x, y) < 0 ? c.compare(y,\
    \ z) < 0 ? y : c.compare(z, x) < 0 ? x : z\n\t\t\t: c.compare(z, y) < 0 ? y :\
    \ c.compare(x, z) < 0 ? x : z;\n\t}\n\n\tpublic static final <T extends Comparable<T>>\
    \ void mergeSort(final T[] a){ mergeSort(a, 0, a.length); } // O(NlogN) N=a.length\n\
    \tpublic static final <T extends Comparable<T>> void mergeSort(final T[] a, final\
    \ int l, final int r){ // O(NlogN)\n\t\tif(r - l > 1) {\n\t\t\tint m = (l + r)\
    \ / 2;\n\t\t\tmergeSort(a, l, m);\n\t\t\tmergeSort(a, m, r);\n\t\t\tmerge(a, l,\
    \ m, r);\n\t\t}\n\t}\n\tprivate static final <T extends Comparable<T>> void merge(final\
    \ T[] a, final int l, final int m, final int r){\n\t\tint i = l;\n\t\tint j =\
    \ m;\n\t\tDeque<T> s = new ArrayDeque<>();\n\t\twhile(i < m || j < r){\n\t\t\t\
    if(j >= r) {\n\t\t\t\ts.addLast(a[i]);\n\t\t\t\ti ++;\n\t\t\t}else if(i >= m)\
    \ {\n\t\t\t\ts.addLast(a[j]);\n\t\t\t\tj ++;\n\t\t\t}else if(a[i].compareTo(a[j])\
    \ < 0) {\n\t\t\t\ts.addLast(a[i]);\n\t\t\t\ti ++;\n\t\t\t}else {\n\t\t\t\ts.addLast(a[j]);\n\
    \t\t\t\tj ++;\n\t\t\t}\n\t\t}\n\t\tfor(int k = l; k < r; k ++) a[k] = s.removeFirst();\n\
    \t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: library/Sort.java
  requiredBy: []
  timestamp: '2022-11-02 13:03:26+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/Sort.java
layout: document
redirect_from:
- /library/library/Sort.java
- /library/library/Sort.java.html
title: library/Sort.java
---
