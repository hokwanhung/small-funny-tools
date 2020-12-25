 public static void Main() {
        int number, i, k, count = 1;
        Console.Write("Enter number of rows\n");
        numberOfLine = int.Parse(Console.ReadLine());
        count = numberOfLine - 1;
        for (k = 1; k <= numberOfLine; k++)
        {
            for (i = 1; i <= count; i++)
                Console.Write(" ");
            count--;
            for (i = 1; i <= 2 * k - 1; i++)
                Console.Write("*");
            Console.WriteLine();
        }
        count = 1;
        for (k = 1; k <= numberOfLine - 1; k++)
        {
            for (i = 1; i <= count; i++)
                Console.Write(" ");
            count++;
            for (i = 1; i <= 2 * (numberOfLine - k) - 1; i++)
                Console.Write("*");
            Console.WriteLine();
        }
        Console.ReadLine();
}
