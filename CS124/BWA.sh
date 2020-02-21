# align each end separately
for item in A B C
do
    bwa aln /n/stat115/2020/HW1/bwa_hg38_index/hg38.fasta ${item}_r.fastq > read1.sai
    bwa aln /n/stat115/2020/HW1/bwa_hg38_index/hg38.fasta ${item}_l.fastq > read2.sai
# stick everything in a SAM file
bwa sampe ref.fasta read1.sai read2.sai read1.fastq read2.fastq > aln-pe.sam
# count number of aligned reads, etc.
samtools flagstat aln-pe.sam
# count number of uniquely mapped reads
samtools view -h aln_pe.sam | grep -v -e 'XA:Z:'  -e 'SA:Z:'| samtools view -F 0x900 -f 0x2 -q 5| wc -l
echo JOB_FINISHED